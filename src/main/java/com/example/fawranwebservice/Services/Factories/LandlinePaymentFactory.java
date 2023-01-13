package com.example.fawranwebservice.Services.Factories;

import com.example.fawranwebservice.Services.LandlinePayment;
import com.example.fawranwebservice.Services.ServiceEntity;

public class LandlinePaymentFactory extends ServiceFactory {
    @Override
    public ServiceEntity Create(String serviceProvider, String serviceName) {
        return new LandlinePayment(serviceProvider,serviceName);
    }
}
