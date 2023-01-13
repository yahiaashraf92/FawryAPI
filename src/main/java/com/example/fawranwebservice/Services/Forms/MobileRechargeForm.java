package com.example.fawranwebservice.Services.Forms;

import java.util.Map;

public class MobileRechargeForm extends Form {

    String phoneNumber;

    public MobileRechargeForm(String provider) {
        super(provider);
    }

    @Override
    protected void Header(Map<String, String> payload) {
        phoneNumber = payload.get("phoneNumber");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
