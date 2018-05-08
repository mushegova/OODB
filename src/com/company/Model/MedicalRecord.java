package com.company.Model;

import java.util.Date;

public class MedicalRecord {
    private Integer id;
    private Integer idPatient;
    private String ambulTreatment;
    private String dateFrom;
    private String dateTo;
    private String dispRegister;
    private String dateStartTreatment;

    public MedicalRecord(Integer id, Integer idPatient, String ambulTreatment, String dateFrom, String dateTo, String dispRegister, String dateStartTreatment){
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

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getDispRegister() {
        return dispRegister;
    }

    public void setDispRegister(String dispRegister) {
        this.dispRegister = dispRegister;
    }

    public String getDateStartTreatment() {
        return dateStartTreatment;
    }

    public void setDateStartTreatment(String dateStartTreatment) {
        this.dateStartTreatment = dateStartTreatment;
    }
}
