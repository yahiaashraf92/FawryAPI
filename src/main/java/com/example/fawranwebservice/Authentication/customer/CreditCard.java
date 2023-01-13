package com.example.fawranwebservice.Authentication.customer;

public class CreditCard {
    String creditCardNumber;

    public CreditCard(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public CreditCard() {
        creditCardNumber = "0000-0000-0000-0000";
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
