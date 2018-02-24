package com.company.Model;

import java.util.Date;

public class MedicalRecord {
    private Integer id;
    private Integer idPatient;
    private String ambulTreatment;
    private Date dateFrom;
    private Date dateTo;
    private String dispRegister;
    private Date dateStartTreatment;

    public MedicalRecord(Integer id, Integer idPatient, String ambulTreatment, Date dateFrom, Date dateTo, String dispRegister, Date dateStartTreatment){
        this.id = id;
        this.idPatient = idPatient;
        this.ambulTreatment = ambulTreatment;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.dispRegister = dispRegister;
        this.dateStartTreatment = dateStartTreatment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public String getAmbulTreatment() {
        return ambulTreatment;
    }

    public void setAmbulTreatment(String ambulTreatment) {
        this.ambulTreatment = ambulTreatment;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getDispRegister() {
        return dispRegister;
    }

    public void setDispRegister(String dispRegister) {
        this.dispRegister = dispRegister;
    }

    public Date getDateStartTreatment() {
        return dateStartTreatment;
    }

    public void setDateStartTreatment(Date dateStartTreatment) {
        this.dateStartTreatment = dateStartTreatment;
    }
}
