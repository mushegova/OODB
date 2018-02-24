package com.company.Model;

public class Specialist {
    private Integer id;
    private String family;
    private String name;
    private String patronymic;
    private String position;
    private String qualification;
    private String specialization;

    public Specialist(Integer id, String family, String name, String patronymic, String position, String qualification, String specialization){
        this.id = id;
        this.family = family;
        this.name = name;
        this.patronymic = patronymic;
        this.position = position;
        this.qualification = qualification;
        this.specialization = specialization;
    }

    public Integer getId() {
        return id;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
