package com.example.fawranwebservice.Payment;

import com.example.fawranwebservice.Authentication.AuthenticationService;
import com.example.fawranwebservice.Discounts.Discount;
import com.example.fawranwebservice.Discounts.DiscountService;
import com.example.fawranwebservice.Authentication.customer.Customer;
import com.example.fawranwebservice.Authentication.customer.Wallet;
import com.example.fawranwebservice.Payment.Model.Receipt;
import com.example.fawranwebservice.Repository.Database;
import com.example.fawranwebservice.Services.ServiceEntity;
import com.example.fawranwebservice.Services.ServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;

@Service
public class PaymentService {
    IPayment payment;
    final ServiceService service;
    final DiscountService discountService;
    final AuthenticationService authentication;
    Database database;

    PaymentService(Database database,DiscountService discountService, ServiceService service, AuthenticationService authentication){
        this.discountService = discountService;
        this.service = service;
        this.authentication = authentication;
        this.database = database;
    }

    public ResponseEntity pay(int choice){
        if(authentication.checkAdmin())
            return new ResponseEntity<>("YOU ARE NOT A CUSTOMER", HttpStatus.FORBIDDEN);

        factoryPayment(choice);

        ServiceEntity service_entity = service.getCurrentService();

        if(service_entity==null)
            return new ResponseEntity<>("There is no service to pay for request a service and submit its form then try again"
                    , HttpStatus.BAD_REQUEST);

        double discount_amount = discountService.getTotaldDiscount(service_entity.getName());
        Customer customer = (Customer)authentication.getCurrent_user();

        payment.setCustomer(customer);
        Receipt receipt = payment.pay(service_entity,discount_amount);

        if(receipt.done) {
            database.addTransaction(customer.getEmail(), receipt);
            return new ResponseEntity<>(receipt, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Try Again",HttpStatus.BAD_REQUEST);
    }

    public void factoryPayment(int choice) {
        if (choice == 1)
            payment = new WalletPayment();

        else if (choice == 2)
            payment = new CreditCardPayment();

        else if (choice == 3)
            payment = new CashPayment();
    }

    public double addCredit(double credit) {
        if(authentication.checkAdmin())
            return -1;
        CreditCardPayment creditCardPayment = new CreditCardPayment();
        Customer customer =(Customer)authentication.getCurrent_user();
        Wallet wallet = customer.getWallet();
        if(creditCardPayment.checkCreditCardCredit(credit,customer)){
            increaseCredit(credit,wallet);
            database.addWalletTransaction(customer.getEmail(),credit);
        }
        return wallet.getCredit();
    }

    public static void increaseCredit(double credit,Wallet wallet){
        wallet.setCredit(credit + wallet.getCredit());
    }

}
