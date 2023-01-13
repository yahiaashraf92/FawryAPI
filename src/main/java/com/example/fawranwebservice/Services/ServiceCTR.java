package com.example.fawranwebservice.Services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/Services")
@RestController
public class ServiceCTR {
    ServiceService service;

    ServiceCTR(ServiceService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getAllServices() {
        if (service.checkCustomer())
            return new ResponseEntity<>(service.getAllServices(),HttpStatus.OK);
        return new ResponseEntity<>("Customers only can use this endpoint.",HttpStatus.FORBIDDEN);
    }

    @GetMapping("/{query}")
    public ResponseEntity searchServices(@PathVariable(value = "query") String query) {
        if (service.checkCustomer())
            return new ResponseEntity<>(service.searchServices(query),HttpStatus.OK);
        return new ResponseEntity<>("Customers only can use this endpoint.",HttpStatus.FORBIDDEN);
    }


    @GetMapping("/serviceProvider/{service}")
    public ResponseEntity getAllServiceProviders(@PathVariable(value = "service") String srvc) {
        if (service.checkCustomer())
            return new ResponseEntity<>(service.getAllServiceProviders(srvc),HttpStatus.OK);
        return new ResponseEntity<>("Customers only can use this endpoint.",HttpStatus.FORBIDDEN);
    }

    @GetMapping("/serviceProvider/{service}/{query}")
    public ResponseEntity searchServiceProviders(@PathVariable(value = "service") String srvc, @PathVariable(value = "query") String query) {
        if (service.checkCustomer())
            return new ResponseEntity<>(service.searchServiceProviders(srvc, query),HttpStatus.OK);
        return new ResponseEntity<>("Customers only can use this endpoint.",HttpStatus.FORBIDDEN);
    }

    @PostMapping("/form")
    public ResponseEntity getForm(@RequestBody Map<String, String> payload) {
        String srvc=payload.get("srvc");
        String srvcprvdr=payload.get("srvcprvdr");
        if (service.checkCustomer()) {
            if(service.checkService(srvc,srvcprvdr)){
                return new ResponseEntity<>(service.CreateForm(srvc, srvcprvdr),HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Wrong service or service provider",HttpStatus.NOT_FOUND);
            }
        }

        return new ResponseEntity<>("Customers only can use this endpoint.",HttpStatus.FORBIDDEN);
    }

    @PostMapping("/form/submit")
    public ResponseEntity submitForm(@RequestBody Map<String, String> payload) {
        if (service.checkCustomer()) {
            service.submitForm(payload);
            return new ResponseEntity<>("Form Submitted Successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("Customers only can use this endpoint.",HttpStatus.FORBIDDEN);
    }

    @PostMapping("/addServiceProvider")
    public ResponseEntity addServiceProvider(@RequestBody Map<String, String> newProvider){
        if (!service.checkCustomer()){
            service.addServiceProvider(newProvider);
            return new ResponseEntity<>("added "+newProvider.get("provider")+" provider to "+ newProvider.get("service"),HttpStatus.OK);
        }
        return new ResponseEntity<>("Admins only can use this endpoint.",HttpStatus.FORBIDDEN);

    }

}


