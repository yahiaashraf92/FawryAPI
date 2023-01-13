package com.example.fawranwebservice.Services;

import com.example.fawranwebservice.Services.Forms.Form;
import com.example.fawranwebservice.Services.Forms.InternetPaymentForm;

public class InternetPayment extends ServiceEntity {
    String landlineNumber;

    public InternetPayment(String serviceProvider,String serviceName) {
        super(serviceProvider,serviceName);
    }

    public InternetPayment(InternetPayment internetPayment) {
        super(internetPayment);
        this.setLandlineNumber(internetPayment.getLandlineNumber());
    }

    @Override
    protected void takeExtra(Form form) {
        setLandlineNumber(((InternetPaymentForm) form).getLandlineNumber());
    }

    public String getLandlineNumber() {
        return landlineNumber;
    }

    public void setLandlineNumber(String landlineNumber) {
        this.landlineNumber = landlineNumber;
    }
}
