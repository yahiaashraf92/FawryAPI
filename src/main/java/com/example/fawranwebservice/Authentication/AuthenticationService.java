package com.example.fawranwebservice.Authentication;

import com.example.fawranwebservice.Authentication.customer.Customer;
import com.example.fawranwebservice.Repository.Database;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    User current_user;
    Database database;

    AuthenticationService(Database database) {
        this.database = database;
    }

    public User login(User user){
        current_user = database.searchRegistered_user(user.getEmail(), user.getPassword());
        return current_user;
    }
    public void logout(){
        current_user=null;
    }
    public boolean register(Customer customer) {
        if(!database.user_exist(customer.getEmail())){
            database.add_Customer(customer);
            current_user = customer;
            return true;
        }
        return false;

    }

    public boolean checkAdmin(){
        return current_user instanceof Admin;
    }

    public User getCurrent_user() {
        return current_user;
    }
}
