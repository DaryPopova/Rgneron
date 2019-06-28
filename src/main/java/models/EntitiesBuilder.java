package models;

import models.entities.Entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static models.ObjectTools.getObject;

/*
link entities that relate to each other. One entity has field that is an array list of another entity
 */
public class EntitiesBuilder {

    public void buildEntities(ArrayList parentEntities, ArrayList childEntities) throws Exception {
        for (Object parentEntity: parentEntities) {
            ArrayList<Entity> listOfChildEntities = new ArrayList<>();
            buildListForOneParentEntity(parentEntity, childEntities, listOfChildEntities);
            for (Object childEntity: listOfChildEntities) {
                initializeParentOwnerOfEntity(childEntity, parentEntity);
            }
        }
    }

    /*
    initiate object which has field that represents ArrayList of current object
    */
    private void initializeParentOwnerOfEntity(Object childEntity, Object parentEntity) throws Exception {
        for (Field field: childEntity.getClass().getFields()) {
            if (field.getAnnotation(ParentOwner.class) != null) {
                field.set(childEntity, parentEntity);
            }
        }
    }

    /*
    Add child entities to list that is field of parent entity for all parent entities
    */
    private void buildListForOneParentEntity(Object parentEntity, ArrayList childEntities, ArrayList<Entity> listOfChildEntities) throws NoSuchFieldException {
        for (Field parentLinkedField : parentEntity.getClass().getDeclaredFields()) {
                addToList(parentEntity, parentLinkedField, childEntities, listOfChildEntities);
        }
    }

    /*
    Add child entities to list that is field of parent entity for one parent entity
    */
    private void addToList(Object parentEntity, Field parentLinkedField, ArrayList childEntities, ArrayList listOfChildEntities) {
        if (ObjectTools.getTypeKind(parentLinkedField).equals(FieldTypeKind.COLLECTION)) {
            try {
                parentLinkedField.set(parentEntity, listOfChildEntities);
            } catch (IllegalAccessException e) {
                System.out.println("IllegalAccessException");
            }
            for (Object childEntity : childEntities) {
                addToListOneChildEntity(parentEntity, childEntity, listOfChildEntities);
            }
        }
    }

    /*
     Add one child entity to list that is field of parent entity for one parent entity
    */
    private void addToListOneChildEntity(Object parentEntity, Object childEntity, ArrayList listOfChildEntities) {
        String[] pairsOfParentAndChildFields = {};
        for (Field parentField: parentEntity.getClass().getDeclaredFields()) {
            if (parentField.getAnnotation(Has.class) != null && parentField.getName().substring(0, parentField.getName().length() - 1).equals(childEntity.getClass().getSimpleName())) {
                pairsOfParentAndChildFields = parentField.getAnnotation(Has.class).pairsOfParentAndChildFields();
            }
        }
        List<List<Field>> parentAndChildFieldsArray = getParentAndChildFieldsList(pairsOfParentAndChildFields, parentEntity, childEntity);
        if (allLinkedFieldValuesEqualsEachOther(parentAndChildFieldsArray, parentEntity, childEntity)) {
            listOfChildEntities.add(childEntity);

        }
    }


    /*
    get pairs of fields for linking parent and child fields from annotation that belongs to field of parent entity
    */
    private List<List<Field>> getParentAndChildFieldsList(String[] pairsOfParentAndChildFields, Object parentEntity, Object childEntity) {
        List<List<Field>> parentAndChildFieldsArray = new ArrayList<>();
        for (String parentAndChildField: pairsOfParentAndChildFields) {
            String parentFieldName = parentAndChildField.split("\\|")[0];
            String childFieldName = parentAndChildField.split("\\|")[1];
            for (Field childField : childEntity.getClass().getDeclaredFields()) {
                for (Field parentField: parentEntity.getClass().getDeclaredFields())
                if (parentField.getName().equals(parentFieldName) && childField.getName().equals(childFieldName)) {
                    List<Field> parentAndChildFieldPair = new ArrayList<>();
                    parentAndChildFieldPair.add(parentField);
                    parentAndChildFieldPair.add(childField);
                    parentAndChildFieldsArray.add(parentAndChildFieldPair);
                }
            }
        }
        return parentAndChildFieldsArray;
    }

    /*
    check that values of child and parent fields for linking equals each other
    */
    private boolean allLinkedFieldValuesEqualsEachOther(List<List<Field>> parentAndChildFieldsArray, Object parentEntity, Object childEntity) {
        boolean allLinkedFieldValuesEqualsEachOther = true;
        for (List<Field> parentAndChildFields: parentAndChildFieldsArray) {
            allLinkedFieldValuesEqualsEachOther = allLinkedFieldValuesEqualsEachOther && getObject(parentAndChildFields.get(1), childEntity).equals(getObject(parentAndChildFields.get(0), parentEntity));
        }
        return allLinkedFieldValuesEqualsEachOther;
    }
}