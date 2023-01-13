package com.example.fawranwebservice.Services.Factories;

import com.example.fawranwebservice.Services.Donations;
import com.example.fawranwebservice.Services.ServiceEntity;

public class DonationsFactory extends ServiceFactory {
    @Override
    public ServiceEntity Create(String serviceProvider, String serviceName) {
        return new Donations(serviceProvider,serviceName);
    }
}
