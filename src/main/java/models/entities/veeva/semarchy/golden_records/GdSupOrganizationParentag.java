package models.entities.veeva.semarchy.golden_records;

import csv.Column;

public class GdSupOrganizationParentag {
    @Column(name = "sup_organization_parentag")
    public String supOrganizationParentag;

    @Column(name = "b_classname")
    public String bClassname;

    @Column(name = "b_pubid")
    public String bPubid;

    @Column(name = "b_sourceid")
    public String bSourceid;

    @Column(name = "b_batchid")
    public Integer bBatchid;

    @Column(name = "b_goldentype")
    public String bGoldentype;

    @Column(name = "b_masterscount")
    public Integer bMasterscount;

    @Column(name = "b_hasoverride")
    public Boolean bHasoverride;

    @Column(name = "b_error_status")
    public String bErrorStatus;

    @Column(name = "b_isconfirmed")
    public Boolean bIsconfirmed;

    @Column(name = "b_confscore")
    public Integer bConfscore;

    @Column(name = "b_confirmationstatus")
    public String bConfirmationstatus;

    @Column(name = "b_hassuggmerge")
    public Boolean bHassuggmerge;

    @Column(name = "b_suggmergeid")
    public Integer bSuggmergeid;

    @Column(name = "b_suggmergeconfscore")
    public Integer bSuggmergeconfscore;

    @Column(name = "b_suggmergemasterscount")
    public Integer bSuggmergemasterscount;

    @Column(name = "b_credate")
    public String bCredate;

    @Column(name = "b_upddate")
    public String bUpddate;

    @Column(name = "b_creator")
    public String bCreator;

    @Column(name = "b_updator")
    public String bUpdator;

    @Column(name = "group_name")
    public String groupName;

    @Column(name = "f_child_id")
    public String fChildId;

    @Column(name = "fp_child_id")
    public String fpChildId;

    @Column(name = "fs_child_id")
    public String fsChildId;

    @Column(name = "f_parent_id")
    public String fParentId;

    @Column(name = "fp_parent_id")
    public String fpParentId;

    @Column(name = "fs_parent_id")
    public String fsParentId;
}
