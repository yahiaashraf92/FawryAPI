package com.example.fawranwebservice.Authentication.customer;

import com.example.fawranwebservice.Authentication.User;

public class Customer extends User {
    Wallet wallet;
    CreditCard creditCard;
    String first_name;
    String last_name;
    String address;

    public Customer(String first_name, String last_name, String address, String email, String password, CreditCard creditCard) {
        super(email, password);
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.wallet = new Wallet();
        this.creditCard = creditCard;
    }
    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

}
