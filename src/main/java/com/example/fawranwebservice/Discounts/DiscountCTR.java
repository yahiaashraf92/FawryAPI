package com.example.fawranwebservice.Discounts;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Discount")
public class DiscountCTR {
    DiscountService discountService;

    public DiscountCTR(DiscountService discountService) {
        this.discountService = discountService;
    }


    @GetMapping
    public ResponseEntity viewAllDiscounts(){
        return new ResponseEntity<>(discountService.getAllDiscount(),HttpStatus.OK);
    }

    @PostMapping("/Overall")
    public ResponseEntity createOverAllDiscount(@RequestBody Discount discount){
        if(discountService.checkAdmin()) {
            discountService.addOverAllDiscount(discount);
            return new ResponseEntity<>("Overall discount added successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("YOU ARE NOT A ADMIN", HttpStatus.FORBIDDEN);
    }
    @PostMapping("/Specific")
    public ResponseEntity createSpecificDiscount(@RequestBody Map<String, Discount> discount){
        if(discountService.checkAdmin()) {
            discountService.addSpecificDiscount(discount);
            return new ResponseEntity<>("Specific discount added successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("YOU ARE NOT A ADMIN", HttpStatus.FORBIDDEN);
    }
    @DeleteMapping()
    public ResponseEntity deleteDiscount(@RequestBody Discount discountDescription){
        if(discountService.checkAdmin()) {
            discountService.deleteDiscount(discountDescription.getDescription());
            return new ResponseEntity<>("Discount Removed",HttpStatus.OK);
        }
        return new ResponseEntity<>("YOU ARE NOT A ADMIN", HttpStatus.FORBIDDEN);
    }
}
