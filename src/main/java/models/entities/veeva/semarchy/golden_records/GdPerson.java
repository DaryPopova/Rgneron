package models.entities.veeva.semarchy.golden_records;

import csv.Column;

public class GdPerson {
    @Column(name = "personid")
    public String personid;

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

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "middle_name")
    public String middleName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "person_type")
    public String personType;

    @Column(name = "gender")
    public String gender;

    @Column(name = "suffix")
    public String suffix;

    @Column(name = "salutation")
    public String salutation;

    @Column(name = "credential")
    public String credential;

    @Column(name = "primary_specialty")
    public String primarySpecialty;

    @Column(name = "secondary_specialty")
    public String secondarySpecialty;

    @Column(name = "verification_status")
    public String verificationStatus;
}
