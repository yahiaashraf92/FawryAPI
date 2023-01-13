package com.example.fawranwebservice.Services.Factories;

import com.example.fawranwebservice.Services.ServiceEntity;


public abstract class ServiceFactory {
    protected static int serviceID=1;
    protected abstract ServiceEntity Create(String serviceProvider, String serviceName);
    public ServiceEntity CreateService(String serviceProvider, String serviceName){
        ServiceEntity service =this.Create(serviceProvider,serviceName);
        service.setID(serviceID++);
        return service;
    }
}
