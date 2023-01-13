package com.example.fawranwebservice.Payment;


import com.example.fawranwebservice.Payment.Model.Receipt;
import com.example.fawranwebservice.Services.ServiceEntity;

public class CashPayment extends IPayment {
    @Override
    public Receipt pay(ServiceEntity service, double discount) {
        String address = customer.getAddress();

        double amount = getServiceCost(service,discount);

        return new Receipt(service, this.getClass().getSimpleName(), amount, true, address,customer);
    }
}
