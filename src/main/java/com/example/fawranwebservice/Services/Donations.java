package com.example.fawranwebservice.Services;

import com.example.fawranwebservice.Services.Forms.Form;

public class Donations extends ServiceEntity {
    public Donations(String serviceProvider,String serviceName) {
        super(serviceProvider,serviceName);
    }

    @Override
    protected void takeExtra(Form form) {

    }

    public Donations(Donations donations) {
        super(donations);
    }

}
