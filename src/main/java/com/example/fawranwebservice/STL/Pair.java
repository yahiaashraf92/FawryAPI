package com.example.fawranwebservice.STL;


import java.util.Calendar;

public class Pair {
    public double credit;
    public Calendar date;

    public Pair(double credit) {
        this.credit = credit;
        this.date = Calendar.getInstance();
    }
}
