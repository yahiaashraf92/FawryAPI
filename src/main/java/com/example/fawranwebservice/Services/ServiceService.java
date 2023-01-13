package com.example.fawranwebservice.Services;

import com.example.fawranwebservice.Authentication.AuthenticationService;
import com.example.fawranwebservice.Repository.Database;
import com.example.fawranwebservice.Services.Factories.ServiceFactory;
import com.example.fawranwebservice.Services.Forms.Factory.FormFactory;
import com.example.fawranwebservice.Services.Forms.Form;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Map;

@Service
public class ServiceService {
    FormFactory formFactory=new FormFactory();
    Database database;
    AuthenticationService authenticationService;
    ServiceEntity currentService;

    ServiceService(Database database, AuthenticationService authenticationService) {
        this.database = database;
        this.authenticationService = authenticationService;
        currentService=null;
    }

    public ServiceEntity getCurrentService() {
        return currentService;
    }

    public LinkedList<String> getAllServices() {
        return database.getAllServices();
    }

    public LinkedList<String> searchServices(String likeService) {
        likeService=likeService.toLowerCase();
        LinkedList<String> matchingKeys = new LinkedList<>();
        for (String key : database.getAllServices()) {
            if (key.toLowerCase().contains(likeService)) {
                matchingKeys.add(key);
            }
        }
        return matchingKeys;
    }

    public boolean checkCustomer() {
        return !(authenticationService.checkAdmin());
    }

    public LinkedList<String> getAllServiceProviders(String service) {
        return database.getAllServiceProviders(service);
    }

    public LinkedList<String> searchServiceProviders(String srvc, String query) {
        query=query.toLowerCase();
        LinkedList<String> matchingKeys = new LinkedList<>();
        for (String key : database.getAllServiceProviders(srvc)) {
            if (key.toLowerCase().contains(query)) {
                matchingKeys.add(key);
            }
        }
        return matchingKeys;
    }
    private void createService(String srvc,String srvcPrvdr){
        ServiceFactory serviceFactory = database.getServiceFactory(srvc);
        currentService = serviceFactory.CreateService(srvcPrvdr,srvc);
    }
    public Form CreateForm(String srvc, String srvcPrvdr) {
        createService(srvc,srvcPrvdr);
        return formFactory.getForm(currentService);
    }
    private void fillService(Map<String,String> payload){
        Form form=formFactory.getForm(currentService);
        form.FillForm(payload);
        currentService.fillService(form);
    }
    public ServiceEntity submitForm(Map<String, String> payload) {
        fillService(payload);
        return currentService;
    }

    public void addServiceProvider(Map<String, String> newProvider) {
        String serviceName = newProvider.get("service");
        String providerName = newProvider.get("provider");
        database.addServiceProvider(serviceName,providerName);
    }

    public boolean checkService(String srvc,String srvcprvdr){
        if(database.checkService(srvc)){
            if(database.checkServiceProvider(srvc,srvcprvdr))
                return true;
        }
        return false;
    }

}