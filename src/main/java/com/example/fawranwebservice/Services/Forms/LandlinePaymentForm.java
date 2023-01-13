package com.example.fawranwebservice.Services.Forms;

import java.util.Map;

public class LandlinePaymentForm extends Form {
    String landlineNumber;

    public LandlinePaymentForm(String provider) {
        super(provider);
    }

    @Override
    protected void Header(Map<String, String> payload) {
        landlineNumber = payload.get("landlineNumber");
    }

    @Override
    public void TakePayment(Map<String, String> payload) {
        this.payment = 30.0;
    }

    public String getLandlineNumber() {
        return landlineNumber;
    }
}
