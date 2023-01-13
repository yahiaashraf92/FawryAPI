package com.example.fawranwebservice.Services;

import com.example.fawranwebservice.Services.Forms.Form;
import com.example.fawranwebservice.Services.Forms.LandlinePaymentForm;

public class LandlinePayment extends ServiceEntity {
    String landlineNumber;

    public LandlinePayment(String serviceProvider,String serviceName) {
        super(serviceProvider,serviceName);
    }

    @Override
    protected void takeExtra(Form form) {
        setLandlineNumber(((LandlinePaymentForm) form).getLandlineNumber());
    }

    public LandlinePayment(LandlinePayment landlinePayment) {
        super(landlinePayment);
        this.setLandlineNumber(landlinePayment.getLandlineNumber());
    }

    public String getLandlineNumber() {
        return landlineNumber;
    }

    public void setLandlineNumber(String landlineNumber) {
        this.landlineNumber = landlineNumber;
    }
}
