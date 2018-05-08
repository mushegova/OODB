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
            /*addPatient(db, 1, "Иванов", "Иван", "Иванович", "11.11.1999", "временно неработающий", "лечится");
            addPatient(db, 2, "Петров", "Иван", "Иванович", "01.01.1960", "пенсионер", "умер");
            addPatient(db, 3, "Иванова", "Анна", "Васильевна", "23.07.1990", "работающий", "вылечился");
            addSpecialist(db, 1, "Васильев", "Андрей", "Александрович", "Врач-специалист", "1", "терапевт");
            addSpecialist(db, 2, "Кузнецова", "Мария", "Андреевна", "Врач-специалист", "2", "невролог");
            addSpecialist(db, 3, "Сергеев", "Василий", "Александрович", "Врач-специалист", "1", "хирург");
            addDiagnosis(db, 1, "Гастрит");
            addDiagnosis(db, 2, "Грипп");
            addDiagnosis(db, 3, "Спино-мозговая грыжа");*/
            addPatient(db, 4, "Иванов", "Иван", "Иванович", "11.11.1999", "учащийся", "вылечится");
            addPatient(db, 5, "Петров", "Иван", "Иванович", "01.01.1960", "пенсионер", "вылечился");
            addPatient(db, 6, "Иванова", "Анна", "Васильевна", "23.07.1990", "работающий", "вылечился");
            addSpecialist(db, 4, "Семенова", "Мария", "Андреевна", "Врач-специалист", "2", "терапевт");
            addSpecRecord(db, 1, 1, 1);
            addSpecRecord(db, 1, 2, 2);
            addSpecRecord(db, 1, 2, 3);
            addSpecRecord(db, 1, 4, 4);
            addMedRec(db, 1, 4, "Y", "01.02.2018", "05.02.2018", "N", "01.02.2018");
            addMedRec(db, 2, 3, "Y", "01.03.2018", "10.03.2018", "N", "01.03.2018");
            addMedRec(db, 3, 6, "Y", "10.03.2018", "19.03.2018", "Y", "10.03.2018");
            addMedRec(db, 4, 6, "N", "01.04.2018", "10.04.2018", "N", "01.04.2018");

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

    public static ObjectSet findSpecRecord(ObjectContainer db, Integer idSpec, Integer idRecord) {
        ObjectSet sr = db.query(new Predicate<Spec_Record>() {
            @Override
            public boolean match(Spec_Record sr) {
                return sr.getIdSpec().equals(idSpec) && sr.getIdRecord().equals(idRecord);
            }
        });
        return sr;
    }

    public static ObjectSet findDiagnosisRecord(ObjectContainer db, Integer idDiagnosis, Integer idRecord) {
        ObjectSet dr = db.query(new Predicate<Diagnosis_Record>() {
            @Override
            public boolean match(Diagnosis_Record dr) {
                return dr.getIdDiagnosis().equals(idDiagnosis) && dr.getIdRecord().equals(idRecord);
            }
        });
        return dr;
    }

    public static ObjectSet findMedRecord(ObjectContainer db, Integer id) {
        ObjectSet dr = db.query(new Predicate<MedicalRecord>() {
            @Override
            public boolean match(MedicalRecord dr) {
                return dr.getId().equals(id);
            }
        });
        return dr;
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

    public static void addSpecRecord(ObjectContainer db, Integer id, Integer idSpec, Integer idRec) {
        ObjectSet sr = findSpecRecord(db, idSpec, idRec);
        if (sr.size() == 0) {
            Spec_Record newSr = new Spec_Record(id, idSpec, idRec);
            db.store(newSr);
        } else {
            System.out.println("Specialist-Record: id:" + id);
        }
    }

    public static void addDiagnRec(ObjectContainer db, Integer id, Integer idDiagnosis, Integer idRecord) {
        ObjectSet dr = findDiagnosisRecord(db, idDiagnosis, idRecord);
        if (dr.size() == 0) {
            Diagnosis_Record newDr = new Diagnosis_Record(id, idDiagnosis, idRecord);
            db.store(newDr);
        } else {
            System.out.println("Diagnosis-Record: id:" + id);
        }
    }

    public static void addMedRec(ObjectContainer db, Integer id, Integer idPatient, String ambulTreatment, String dateFrom, String dateTo, String dispRegister, String dateStartTreatment) {
        ObjectSet dr = findMedRecord(db, id);
        if (dr.size() == 0) {
            MedicalRecord newMed = new MedicalRecord(id, idPatient, ambulTreatment, dateFrom, dateTo, dispRegister, dateStartTreatment);
            db.store(newMed);
        } else {
            System.out.println("Medical record: id:" + id);
        }
    }

    public static ObjectSet findSpecialistByQualification(ObjectContainer db, String qualification) {
        ObjectSet specialist = db.query(new Predicate<Specialist>() {
            @Override
            public boolean match(Specialist specialist) {
                return specialist.getQualification().equals(qualification);
            }
        });
        return specialist;
    }

    public static ObjectSet findPatientByStatus(ObjectContainer db, String status) {
        ObjectSet patient = db.query(new Predicate<Patient>() {
            @Override
            public boolean match(Patient patient) {
                return patient.getStatus().equalsIgnoreCase(status);
            }
        });
        return patient;
    }

    public static ObjectSet findPatientByStateStatus(ObjectContainer db, String state, String status) {
        ObjectSet patient = db.query(new Predicate<Patient>() {
            @Override
            public boolean match(Patient patient) {
                return (patient.getState().equalsIgnoreCase(state) &&
                        patient.getStatus().equalsIgnoreCase(status));
            }
        });
        return patient;
    }

    public static ObjectSet findRecordByIdPatient(ObjectContainer db, Integer id) {
        ObjectSet record = db.query(new Predicate<MedicalRecord>() {
            @Override
            public boolean match(MedicalRecord record) {
                return record.getIdPatient().equals(id);
            }
        });
        return record;
    }

    public static void printMostWorkPatient(ObjectContainer db) {
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        Integer mostPatientCount = 0;
        ObjectSet patWork = findPatientByStatus(db, "Работаюий");
        ObjectSet specialists = findSpecialistByQualification(db, "2");
        ObjectSet record;
        ObjectSet specRecord;
        MedicalRecord medRecord;

        while (patWork.hasNext()) {
            Patient patient = (Patient) patWork.next();
            while (specialists.hasNext()) {
                Specialist specialist = (Specialist) specialists.next();
                record = findRecordByIdPatient(db, patient.getId());
                if (record != null) {
                    medRecord = (MedicalRecord) record;
                    specRecord = findSpecRecord(db, specialist.getId(), medRecord.getId());
                    if (specRecord != null)
                        mostPatientCount++;
                }
                System.out.println("Specialist " + specialist.getFamily() + " " + specialist.getName() + " " + specialist.getPatronymic() +": "+mostPatientCount);
            }
        }
    }

    public static void printStudyPatient(ObjectContainer db, ObjectSet specialists){
        Integer mostPatientCount = 0;
        ObjectSet patStudy = findPatientByStatus(db, "Учащийся");
        ObjectSet record;
        ObjectSet specRecord;
        MedicalRecord medRecord;

        while (patStudy.hasNext()) {
            Patient patient = (Patient) patStudy.next();
            while (specialists.hasNext()) {
                Specialist specialist = (Specialist) specialists.next();
                record = findRecordByIdPatient(db, patient.getId());
                if (record != null) {
                    medRecord = (MedicalRecord) record;
                    specRecord = findSpecRecord(db, specialist.getId(), medRecord.getId());
                    if (specRecord != null)
                        mostPatientCount++;
                }
            }
            if(mostPatientCount > 1)
                System.out.println("Patient " + patient.getFamily() + " " + patient.getName() + " " + patient.getPatronymic() +": "+mostPatientCount);
        }
    }

    public static void printPatientWithPension(ObjectContainer db, ObjectSet<Patient> patients) {

        while(patients.hasNext()) {
            Patient patient = (Patient) patients.next();
            ObjectSet<Patient> patientPens = findPatientByStateStatus(db, "Пенсионер", "Направлен в стационар");

            if(patientPens.size() > 0) {
                System.out.println("Patient " + patient.getFamily() + " " + patient.getName() + " " + patient.getPatronymic() +
                        "state: Пенсионер status: направлен в стационар");
            }
        }
    }

    public static void printPatient(ObjectContainer db) {
        ObjectSet patWork = findPatientByStateStatus(db, "Вылечился","Учащийся");
        ObjectSet specialists = findSpecialistByQualification(db, "1");
        ObjectSet record;
        ObjectSet specRecord;
        MedicalRecord medRecord;

        while (specialists.hasNext()) {
            Specialist specialist = (Specialist) specialists.next();
            while (patWork.hasNext()) {
                Patient patient = (Patient) patWork.next();
                record = findRecordByIdPatient(db, patient.getId());
                if (record != null) {
                    medRecord = (MedicalRecord) record;
                    specRecord = findSpecRecord(db, specialist.getId(), medRecord.getId());
                    if (specRecord != null)
                        System.out.println("Patient: " + patient.getFamily() + " " + patient.getName() + " " + patient.getPatronymic() +
                                "Specialist 1 cat: " + specialist.getFamily() + " " + specialist.getName() + " " + specialist.getPatronymic());
                }
            }
        }
    }

}
