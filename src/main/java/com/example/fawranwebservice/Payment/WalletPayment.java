package com.example.fawranwebservice.Payment;

import com.example.fawranwebservice.Payment.Model.Receipt;
import com.example.fawranwebservice.Services.ServiceEntity;

public class WalletPayment extends IPayment {
    @Override
    public Receipt pay(ServiceEntity service, double discount) {

        double amount = getServiceCost(service,discount);
        if (customer.getWallet().decreaseCredit(amount))
            return new Receipt(service, this.getClass().getSimpleName(), amount, true,customer);

        return new Receipt(service, this.getClass().getSimpleName(), amount, false,customer);
    }
}
