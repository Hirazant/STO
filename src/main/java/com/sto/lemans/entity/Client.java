package com.sto.lemans.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "client_name")
    @NotBlank(message = "REQUIRED FIELD")
    private String clientName;

    @Column(name = "client_lastname")
    private String clientLastname;

    @Column(name = "client_middlename")
    private String clientMiddlename;

    @Column(name = "car_brand")
    private String carBrand;

    @Column(name = "car_model")
    private String carModel;

    @Column(name = "car_year")
    private int carYear;

    @Column(name = "car_mileage")
    private int carMileage;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<CarSession> sessions;

    public Client() {
    }

    public Client(String clientName, String clientLastname, String clientMiddlename,
                  String carBrand, String carModel, int carYear, int carMileage) {
        this.clientName = clientName;
        this.clientLastname = clientLastname;
        this.clientMiddlename = clientMiddlename;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carYear = carYear;
        this.carMileage = carMileage;
    }

    public void addSession(CarSession carSession) {
        if (sessions == null) {
            sessions = new ArrayList<>();
        }

        sessions.add(carSession);
        carSession.setClient(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientLastname() {
        return clientLastname;
    }

    public void setClientLastname(String clientLastname) {
        this.clientLastname = clientLastname;
    }

    public String getClientMiddlename() {
        return clientMiddlename;
    }

    public void setClientMiddlename(String clientMiddlename) {
        this.clientMiddlename = clientMiddlename;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public int getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(int carMileage) {
        this.carMileage = carMileage;
    }

    public List<CarSession> getSessions() {
        return sessions;
    }

    public void setSessions(List<CarSession> sessions) {
        this.sessions = sessions;
    }


}
