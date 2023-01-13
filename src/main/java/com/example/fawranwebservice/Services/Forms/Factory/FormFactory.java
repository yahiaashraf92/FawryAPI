package com.example.fawranwebservice.Services.Forms.Factory;

import com.example.fawranwebservice.Services.*;
import com.example.fawranwebservice.Services.Forms.*;



public class FormFactory {
    //use getForm method to get object of type Form
    public Form getForm(ServiceEntity service){
        if(service == null){
            return null;
        }
        if(service instanceof Donations){
            return new DonationsForm(service.getProvider());

        } else if(service instanceof InternetPayment){
            return new InternetPaymentForm(service.getProvider());

        } else if(service instanceof LandlinePayment){
            return new LandlinePaymentForm(service.getProvider());

        } else if(service instanceof MobileRecharge){
            return new MobileRechargeForm(service.getProvider());
        }

        return null;
    }
}
