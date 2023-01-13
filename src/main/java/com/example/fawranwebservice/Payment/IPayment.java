package com.example.fawranwebservice.Payment;

import com.example.fawranwebservice.Authentication.customer.Customer;
import com.example.fawranwebservice.Payment.Model.Receipt;
import com.example.fawranwebservice.Services.ServiceEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class IPayment {

    Customer customer;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    double getServiceCost(ServiceEntity service, double discount) {

        return service.getPayment() * (1 - discount);

    }

    abstract Receipt pay(ServiceEntity service, double discount);
}
