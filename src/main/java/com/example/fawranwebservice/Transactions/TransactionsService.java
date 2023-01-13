package com.example.fawranwebservice.Transactions;

import com.example.fawranwebservice.Authentication.AuthenticationService;
import com.example.fawranwebservice.Payment.Model.Receipt;
import com.example.fawranwebservice.Repository.Database;
import com.example.fawranwebservice.STL.Pair;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Map;

@Service
public class TransactionsService {

    Database database;
    AuthenticationService authentication;

    public TransactionsService(Database database, AuthenticationService authentication) {
        this.database = database;
        this.authentication = authentication;
    }


    public Map<String, LinkedList<Receipt>> getAllServiceTransactions() {
        return database.getAllServiceTransactions();
    }
    public Map<String, LinkedList<Pair>> getAllWalletTransactions(){
        return database.getAllWalletTransactions();
    }
    public boolean checkAdmin(){
        return authentication.checkAdmin();
    }

    public LinkedList<Receipt> getCustomerServiceTransactions() {
        return database.getTransactionsReceipts(authentication.getCurrent_user().getEmail());
    }

    public LinkedList<Pair> getCustomerWalletTransactions() {
        return database.getCustomerWalletTransactions(authentication.getCurrent_user().getEmail());
    }
}
