package com.example.fawranwebservice.Refunds;

import com.example.fawranwebservice.Authentication.AuthenticationService;
import com.example.fawranwebservice.Authentication.customer.Customer;
import com.example.fawranwebservice.Payment.Model.Receipt;
import com.example.fawranwebservice.Repository.Database;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class RefundRequestService {

    Database database;
    AuthenticationService authentication;

    public RefundRequestService(Database database,AuthenticationService authentication){
        this.database = database;
        this.authentication = authentication;
    }

    public boolean checkAdmin(){
        return authentication.checkAdmin();
    }
    public ResponseEntity display() {
        Map<String,LinkedList<Receipt>> RefundRequests=database.getAllRefundRequests();
        if(RefundRequests.isEmpty()){
            return new ResponseEntity<>("No Refund Requests at the moment.",HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity(RefundRequests,HttpStatus.OK);
        }
    }

    public boolean accept(String email,int id) {
        double Totalpayed;
        LinkedList<Receipt> customer_transactions = database.getTransactionsReceipts(email);
        LinkedList<Receipt> requests = database.getRequestsReceipts(email);
        boolean flag=false;
        for (int i=0;i<customer_transactions.size();i++) {
            if (Objects.equals(customer_transactions.get(i).getServiceID(), id)) {
                for(int j = 0;j<requests.size();j++){
                    if(Objects.equals(requests.get(j).getServiceID(),id)){
                        flag=true;
                        Totalpayed = customer_transactions.get(i).getCost();
                        database.deleteRequest(email,j);
                        database.deleteTransaction(email,i);


                        Customer customer = (Customer) database.getCustomer(email);
                        customer.getWallet().setCredit(Totalpayed+(customer.getWallet().getCredit()));
                        break;
                    }
                }
            }
        }
        return flag;
    }
    public boolean request(int id) {
        LinkedList<Receipt> myReceipt = database.getTransactionsReceipts(authentication.getCurrent_user().getEmail());
        boolean flag = false;
        for (Receipt receipt : myReceipt) {
            if (Objects.equals(receipt.getServiceID(), id)) {
                database.addRequest(authentication.getCurrent_user().getEmail(),receipt);
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean reject(String email,int id) {
        LinkedList<Receipt> requests = database.getRequestsReceipts(email);
        boolean flag=false;
        for (int i=0;i<requests.size();i++) {
            if (Objects.equals(requests.get(i).getServiceID(), id)) {
                flag=true;
                database.deleteRequest(email,i);
                break;
            }
        }
        return flag;
    }
}
