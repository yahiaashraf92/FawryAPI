package com.example.fawranwebservice.Discounts;

import java.util.Calendar;
import java.util.Date;

public class Discount {
    String description;
    double percentage;
    Calendar date;

    Discount(String d, double p) {
        description = d;
        percentage = p;
        date = Calendar.getInstance();
    }

    public double getPercentage() {
        return percentage;
    }

    public Calendar getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setDate() {
        this.date = Calendar.getInstance();
    }

}
