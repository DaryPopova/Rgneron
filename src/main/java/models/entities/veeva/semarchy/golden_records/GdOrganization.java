package models.entities.veeva.semarchy.golden_records;

import csv.Column;
import models.Has;

import java.util.ArrayList;

public class GdOrganization {
    @Column(name = "organizationid")
    public String organizationid;

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

    @Column(name = "legal_business_name")
    public String legalBusinessName;

    @Column(name = "dba_name")
    public String dbaName;

    @Column(name = "verification_status")
    public String verificationStatus;

    @Column(name = "account_type")
    public String accountType;

    @Column(name = "account_sub_type")
    public String accountSubType;

    @Column(name = "account_status")
    public String accountStatus;

    @Column(name = "class_of_trade_rgn")
    public String classOfTradeRgn;

    @Column(name = "class_of_trade_ims")
    public String classOfTradeIms;

    @Has(pairsOfParentAndChildFields = {"b_pubid|fp_org_id", "b_sourceid|fs_org_id"})
    public ArrayList<GdOrgExtIdentifier> gdOrgExtIdentifiers;
}