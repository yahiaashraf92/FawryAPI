package com.example.fawranwebservice.Payment;

import com.example.fawranwebservice.Authentication.customer.CreditCard;
import com.example.fawranwebservice.Authentication.customer.Customer;
import com.example.fawranwebservice.Payment.Model.Receipt;
import com.example.fawranwebservice.Services.ServiceEntity;

public class CreditCardPayment extends IPayment {

    @Override
    public Receipt pay(ServiceEntity service, double discount) {
        CreditCard creditCard = customer.getCreditCard();

        double amount = getServiceCost(service,discount);

        if(completePayment(creditCard,amount))
            return new Receipt(service,this.getClass().getSimpleName(),amount,true,customer);

        return new Receipt(service,this.getClass().getSimpleName(),amount,false,customer);

    }
    public boolean completePayment(CreditCard creditCard,double payment){
        /*
        This Function gives the bank api the credit-card info and payment amount then Asks it For The Purchase
        return true if Transaction is completed
        false otherwise
        */
        return creditCard!=null;
    }
    public boolean checkCreditCardCredit(double amount, Customer cust){
        CreditCard creditCard = cust.getCreditCard();
        return completePayment(creditCard,amount);
    }
}
