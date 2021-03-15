package com.sto.lemans.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "master")
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(unique = true, name = "master_number")
    @Min(value = 0, message = "Can't be negative!")
    private int masterNumber;

    @Column(name = "master_name")
    private String masterName;

    @Column(name = "master_lastname")
    private String masterLastname;

    @Column(name = "master_middlename")
    private String masterMiddlename;

    @Column(name = "master_specialization")
    private String masterSpecialization;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "master")
    private List<CarSession> sessions;

    public Master() {
    }

    public Master(int masterNumber, String masterName, String masterLastname, String masterMiddlename, String masterSpecialization) {
        this.masterNumber = masterNumber;
        this.masterName = masterName;
        this.masterLastname = masterLastname;
        this.masterMiddlename = masterMiddlename;
    }

    public void addSession(CarSession carSession) {
        if (sessions == null) {
            sessions = new ArrayList<>();
        }

        sessions.add(carSession);
        carSession.setMaster(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMasterNumber() {
        return masterNumber;
    }

    public void setMasterNumber(int masterNumber) {
        this.masterNumber = masterNumber;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterLastname() {
        return masterLastname;
    }

    public void setMasterLastname(String masterLastname) {
        this.masterLastname = masterLastname;
    }

    public String getMasterMiddlename() { return masterMiddlename;}

    public void setMasterMiddlename(String masterMiddlename) {
        this.masterMiddlename = masterMiddlename;
    }

    public String getMasterSpecialization() {
        return masterSpecialization;
    }

    public void setMasterSpecialization(String masterSpecialization) {
        this.masterSpecialization = masterSpecialization;
    }

    public List<CarSession> getSessions() {
        return sessions;
    }

    public void setSessions(List<CarSession> sessions) {
        this.sessions = sessions;
    }
}
