package com.example.fawranwebservice.Payment;

import com.example.fawranwebservice.Discounts.Discount;
import com.example.fawranwebservice.Payment.Model.Receipt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@RestController
@RequestMapping("/Payment")
public class PaymentCTR {

    public final PaymentService paymentservice;


    PaymentCTR(PaymentService paymentservice) {
        this.paymentservice = paymentservice;
    }

    @GetMapping("/{choice}")
    public ResponseEntity pay(@PathVariable("choice") int choice) {
        return paymentservice.pay(choice);
    }

    @PutMapping
    public ResponseEntity addCredit(@RequestBody Map<String,Double> payload){
        double credit = paymentservice.addCredit(payload.get("money"));
        if(credit == -1) {
            return new ResponseEntity<>("YOU ARE NOT A CUSTOMER", HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(credit+" pounds Added to wallet successfully",HttpStatus.OK);
    }

}
