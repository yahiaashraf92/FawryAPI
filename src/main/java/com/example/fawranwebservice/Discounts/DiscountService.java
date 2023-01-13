package com.example.fawranwebservice.Discounts;

import com.example.fawranwebservice.Authentication.AuthenticationService;
import com.example.fawranwebservice.Repository.Database;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DiscountService {

    Database database;
    AuthenticationService authentication;

    public DiscountService(Database database,AuthenticationService authentication)
    {
        this.authentication = authentication;
        this.database = database;
    }

    public double getTotaldDiscount(String service){
        LinkedList<Discount> list = database.getDiscounts(service);
        double totalDiscount = 0;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).date.add(Calendar.MONTH, 1);
                if (list.get(i).date.after(Calendar.getInstance())) {
                    totalDiscount += list.get(i).percentage;
                } else {
                    database.removeDiscount(service, i);
                    i--;
                }
                list.get(i).date.add(Calendar.MONTH, -1);
            }
        }
        return totalDiscount;
    }

    public HashMap<String, LinkedList<Discount>> getAllDiscount() {
        return database.getAllDiscounts();
    }

    public void addOverAllDiscount(Discount discount) {
        database.addOverAll(discount);
    }

    public void addSpecificDiscount(Map<String, Discount> discount) {
        Set<String> keys = discount.keySet();
        for(String key : keys){
            database.addSpecific(discount.get(key),key);
        }
    }

    public void deleteDiscount(String discountDescription) {
        database.removeDiscount(discountDescription);
    }

    public boolean checkAdmin(){
        return authentication.checkAdmin();
    }

}
