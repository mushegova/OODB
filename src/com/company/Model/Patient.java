package com.company.Model;

import java.util.Date;

public class Patient {
    private Integer id;
    private String family;
    private String name;
    private String patronymic;
    private String birthday;
    private String status;
    private String state;

    public Patient(Integer id, String family, String name, String patronymic, String birthday, String status, String state){
        this.id = id;
        this.family = family;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.status = status;
        this.state = state;
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
