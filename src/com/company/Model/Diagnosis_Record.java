package com.company.Model;

public class Diagnosis_Record {
    private  Integer id;
    private  Integer idDiagnosis;
    private Integer idRecord;

    public  Diagnosis_Record(Integer id, Integer idDiagnosis, Integer idRecordid){
        this.id = id;
        this.idDiagnosis = idDiagnosis;
        this.idRecord = idRecordid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdDiagnosis() {
        return idDiagnosis;
    }

    public void setIdDiagnosis(Integer idDiagnosis) {
        this.idDiagnosis = idDiagnosis;
    }

    public Integer getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(Integer idRecord) {
        this.idRecord = idRecord;
    }
}
