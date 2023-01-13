package com.example.fawranwebservice.Transactions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Transactions")
public class TransactionsCTR {
    TransactionsService transactionsservice;

    public TransactionsCTR(TransactionsService transactionsservice){
        this.transactionsservice = transactionsservice;
    }

    @GetMapping("/ServiceTransactions")
    public ResponseEntity serviceTransactions(){
        if(transactionsservice.checkAdmin())
            return new ResponseEntity<>(transactionsservice.getAllServiceTransactions(),HttpStatus.OK);
        return new ResponseEntity<>(transactionsservice.getCustomerServiceTransactions(),HttpStatus.OK);
    }

    @GetMapping("/WalletTransactions")
    public ResponseEntity walletTransactions(){
        if(transactionsservice.checkAdmin())
            return new ResponseEntity<>(transactionsservice.getAllWalletTransactions(),HttpStatus.OK);
        return new ResponseEntity<>(transactionsservice.getCustomerWalletTransactions(),HttpStatus.OK);

    }
}
