package com.example.fawranwebservice.Payment.Model;

import com.example.fawranwebservice.Authentication.customer.Customer;
import com.example.fawranwebservice.Services.ServiceEntity;

import java.util.Calendar;

public class Receipt {
    String serviceAndProvider;
    static int IDgenerator = 0;
    int serviceID;
    double cost;
    Customer customer;
    String payment;
    public boolean done;
    String address ="";
    Calendar date;


    public Receipt(ServiceEntity service, String payment, double cost, boolean status,Customer customer){
        serviceAndProvider=service.getClass().getSimpleName()+" "+service.getProvider();
        serviceID = ++IDgenerator;
        this.payment = payment;
        this.cost = cost;
        done = status;
        date = Calendar.getInstance();
        this.customer = customer;
    }
    public Receipt(ServiceEntity service, String payment, double cost, boolean status, String address,Customer customer){
        serviceAndProvider=service.getClass().getSimpleName()+" "+service.getProvider();
        serviceID = ++IDgenerator;
        this.payment = payment;
        this.cost = cost;
        done = status;
        this.address = address;
        date = Calendar.getInstance();
        this.customer = customer;
    }

    public String getAddress() {
        return address;
    }

    public Calendar getDate() {
        return date;
    }

    public double getCost() {
        return cost;
    }

    public int getServiceID() {
        return serviceID;
    }

    public String getPayment() {
        return payment;
    }

    public String getServiceAndProvider() {
        return serviceAndProvider;
    }
}
