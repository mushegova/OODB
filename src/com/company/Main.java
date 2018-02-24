package com.company;

import com.company.Model.*;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "DataBase_Hospital");

        try {
            //работа с ООБД
            addPatient(db, 1, "Иванов", "Иван", "Иванович", "11.11.1999", "временно неработающий", "лечится");
            addPatient(db, 2, "Петров", "Иван", "Иванович", "01.01.1960", "пенсионер", "умер");
            addPatient(db, 3, "Иванова", "Анна", "Васильевна", "23.07.1990", "работающий", "вылечился");
            addSpecialist(db, 1, "Васильев", "Андрей",  "Александрович", "Врач-специалист", "1", "терапевт");
            addSpecialist(db, 2, "Кузнецова", "Мария",  "Андреевна", "Врач-специалист", "2", "невролог");
            addSpecialist(db, 3, "Сергеев", "Василий",  "Александрович", "Врач-специалист", "1", "хирург");
            addDiagnosis(db, 1, "Гастрит");
            addDiagnosis(db, 2, "Грипп");
            addDiagnosis(db, 3, "Спино-мозговая грыжа");

        } finally {
            db.close();
        }
    }

    public static void listResult(List<?> result) {
        for (Object obj :
                result) {
            System.out.println(result);
        }
    }

    public static void clearDb(ObjectContainer db) {
        ObjectSet result = db.queryByExample(new Object());
        while (result.hasNext()) db.delete(result.hasNext());
    }

    public static ObjectSet findPatient(ObjectContainer db, Integer id) {
        ObjectSet patient = db.query(new Predicate<Patient>() {
            @Override
            public boolean match(Patient patient) {
                return patient.getId().equals(id);
            }
        });
        return patient;
    }

    public static ObjectSet findSpecialist(ObjectContainer db, Integer id) {
        ObjectSet specialist = db.query(new Predicate<Specialist>() {
            @Override
            public boolean match(Specialist specialist) {
                return specialist.getId().equals(id);
            }
        });
        return specialist;
    }

    public static ObjectSet findDiagnosis(ObjectContainer db, String name) {
        ObjectSet diagnosis = db.query(new Predicate<Diagnosis>() {
            @Override
            public boolean match(Diagnosis diagnosis) {
                return diagnosis.getName().equals(name);
            }
        });
        return diagnosis;
    }

    public static void addPatient(ObjectContainer db, Integer id, String family, String name, String patronymic, String birthday, String status, String state) {
        ObjectSet patient = findPatient(db, id);
        if (patient.size() == 0) {
            Patient newPatient = new Patient(id, family, name, patronymic,
                    birthday, status, state);
            db.store(newPatient);
        } else {
            System.out.println("Patient: " + family + " " + name + " " + patronymic + " : " +
                    id);
        }
    }

    public static void addSpecialist(ObjectContainer db, Integer id, String family, String name, String patronymic, String position, String qualification, String specialization) {
        ObjectSet specialist = findSpecialist(db, id);
        if (specialist.size() == 0) {
            Specialist newSpecialist = new Specialist(id, family, name, patronymic,
                    position, qualification, specialization);
            db.store(newSpecialist);
        } else {
            System.out.println("Specialist: " + family + " " + name + " " + patronymic + " : " +
                    id);
        }
    }

    public static void addDiagnosis(ObjectContainer db, Integer id, String name) {
        ObjectSet diagnosis = findDiagnosis(db, name);
        if (diagnosis.size() == 0) {
            Diagnosis newDiagnosis = new Diagnosis(id, name);
            db.store(newDiagnosis);
        } else {
            System.out.println("Diagnosis: " + name + " : " + id);
        }
    }
}

