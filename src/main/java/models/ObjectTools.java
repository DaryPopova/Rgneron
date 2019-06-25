package models;

import csv.Column;
import database.DbField;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;

public class ObjectTools {
    public static FieldTypeKind getTypeKind(Field field) {
        if (!(field.getType().equals(Class.class) || Arrays.stream(field.getDeclaredAnnotations()).anyMatch(
                annotation -> annotation instanceof NonReflectable))) {
            if (!Collection.class.isAssignableFrom(field.getType())) {
                if (field.getType().isPrimitive() || new Primitive().primitiveClasses.contains(field.getType())) {
                    return FieldTypeKind.PRIMITIVE;
                }
                else if (field.getType().equals(String.class)) {
                    return FieldTypeKind.STRING;
                }
                else {
                    return FieldTypeKind.COMPLEX;
                }
            } else {
                return FieldTypeKind.COLLECTION;
            }
        }
        else return FieldTypeKind.DEFAULT;
    }


    public static Object toTypeWithValue(Class clazz, String value) throws Exception{
      if(clazz == String.class) {
          return value;
      }
      else if(clazz == Integer.class) {
          return Integer.parseInt(value);
      }
      else if(clazz == Double.class) {
          return Double.parseDouble(value);
      }
      else throw new Exception("Тип не поддерживается");
    }

    public static Object getObject(Field field, Object object) {
        try {
            if (field != null && field.get(object) != null) {
                return field.get(object);
            } else return "[null]";
        } catch (IllegalAccessException e) {
            return "Исключение IllegalAccessException";
        }
    }

    public static Object getTypeOfObject(Field field, Object object) {
        try {
            if (field == null) {
                return "[null]";
            } else if (field.get(object) == null) {
                return field.getType();
            } else return field.get(object).getClass();
        } catch (IllegalAccessException e) {
            return "Исключение IllegalAccessException";
        }
    }

    public static String getColumnName(Field field) {
        Annotation annotation = field.getAnnotation(Column.class);
        Column columnAnnotation = (Column) annotation;
        if (columnAnnotation == null) {
            return null;
        } else return columnAnnotation.name();
    }

    public String getDbFieldName(Field field) {
        Annotation annotation = field.getAnnotation(DbField.class);
        DbField columnAnnotation = (DbField) annotation;
        if (columnAnnotation == null) {
            return null;
        } else return columnAnnotation.name();
    }
}