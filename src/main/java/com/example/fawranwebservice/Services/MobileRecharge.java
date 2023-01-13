package com.example.fawranwebservice.Services;

import com.example.fawranwebservice.Services.Forms.Form;
import com.example.fawranwebservice.Services.Forms.MobileRechargeForm;
import org.jetbrains.annotations.NotNull;


public class MobileRecharge extends ServiceEntity {
    private String phoneNumber;

    public MobileRecharge(String serviceProvider,String serviceName) {
        super(serviceProvider,serviceName);
    }

    public MobileRecharge(MobileRecharge mobileRecharge) {
        super(mobileRecharge);
        this.setPhoneNumber(mobileRecharge.getPhoneNumber());
    }

    @Override
    protected void takeExtra(@NotNull Form form) {
        setPhoneNumber(((MobileRechargeForm) form).getPhoneNumber());
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
