package com.example.fawranwebservice.Services.Forms;

import java.util.Map;

public class InternetPaymentForm extends Form {
    String landlineNumber;
    public InternetPaymentForm(String provider){
        super(provider);
    }

    @Override
    protected void Header(Map<String, String> payload) {
        landlineNumber = payload.get("landlineNumber");
    }


    public String getLandlineNumber() {
        return landlineNumber;
    }
}
