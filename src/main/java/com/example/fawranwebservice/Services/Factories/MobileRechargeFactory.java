package com.example.fawranwebservice.Services.Factories;

import com.example.fawranwebservice.Services.MobileRecharge;
import com.example.fawranwebservice.Services.ServiceEntity;

public class MobileRechargeFactory extends ServiceFactory {
    @Override
    public ServiceEntity Create(String serviceProvider, String serviceName) {
        return new MobileRecharge(serviceProvider,serviceName);
    }
}
