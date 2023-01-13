package com.example.fawranwebservice.Services;

import com.example.fawranwebservice.Services.Forms.Form;

import java.util.Date;

public abstract class ServiceEntity {
    protected String provider;
    protected String name;
    protected Date date;
    protected double payment;
    protected int ID;

    ServiceEntity(String provider, String serviceName) {
        this.setName(serviceName);
        this.setProvider(provider);
    }

    ServiceEntity(ServiceEntity service) {
        this.setName(service.getName());
        this.setProvider(service.getProvider());
        this.setDate(service.getDate());
        this.setPayment(service.getPayment());
        this.setID(service.getID());
    }

    public void fillService(Form form) {
        setDate(form.getDate());
        setPayment(form.getPayment());
        takeExtra(form);
    }

    protected abstract void takeExtra(Form form);

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
