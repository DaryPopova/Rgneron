package models.entities.medpro;

import csv.Column;
import models.entities.Entity;

public class Employee extends Entity {
    @Column(name = "record_type")
    public Integer recordType;
    @Column(name = "record_number")
    public Integer recordNumber;
    @Column(name = "inbound_last_name")
    public String inboundLastName;

    @Override
    public String toString()
    {
        return "Employee [recordType=" + recordType + ", recordNumber=" + recordNumber + ", inboundLastName=" +
                inboundLastName + "]";
    }
}