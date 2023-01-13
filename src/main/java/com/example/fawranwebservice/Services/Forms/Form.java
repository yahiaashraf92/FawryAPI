package com.example.fawranwebservice.Services.Forms;

import java.util.Date;
import java.util.Map;

public class Form {
    String provider;
    Date date;
    double payment;

    public Form(String provider) {
        this.provider = provider;
    }

    protected void Header(Map<String, String> payload){}

    public void FillForm(Map<String,String>payload) {
        Header(payload);
        TakePayment(payload);
        setDate();
    }

    public void TakePayment(Map<String, String> payload) {
        this.payment =  Double.parseDouble(payload.get("payment"));
    }

    public double getPayment() {
        return payment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate() {
        this.date = new Date();
    }
}
