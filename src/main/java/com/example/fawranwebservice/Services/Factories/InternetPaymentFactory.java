package com.example.fawranwebservice.Services.Factories;

import com.example.fawranwebservice.Services.InternetPayment;
import com.example.fawranwebservice.Services.ServiceEntity;

public class InternetPaymentFactory extends ServiceFactory {
    @Override
    public ServiceEntity Create(String serviceProvider, String serviceName) {
        return new InternetPayment(serviceProvider,serviceName);
    }
}
