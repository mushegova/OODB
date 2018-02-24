package com.company.Model;

public class Spec_Record {
    private Integer id;
    private Integer idSpec;
    private Integer idRecord;

    public Spec_Record(Integer id, Integer idSpec, Integer idRecord){
        this.id = id;
        this.idSpec = idSpec;
        this.idRecord = idRecord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdSpec() {
        return idSpec;
    }

    public void setIdSpec(Integer idSpec) {
        this.idSpec = idSpec;
    }

    public Integer getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(Integer idRecord) {
        this.idRecord = idRecord;
    }
}
