package com.example.fawranwebservice.Authentication;

import com.example.fawranwebservice.Authentication.customer.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Authentication")
public class AuthenticationCTR {
    // DIRECT THE REQUEST
    AuthenticationService authentication;

    public AuthenticationCTR(AuthenticationService authentication) {
        this.authentication = authentication;
    }


    @PostMapping("/Login")
    public ResponseEntity login(@RequestBody User user){
        user = authentication.login(user);
        if(user != null){
            return new ResponseEntity<>("Log in Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>( "Log in Unsuccessfully",HttpStatus.BAD_REQUEST);
    }


    @PostMapping("/Register")
    public ResponseEntity register(@RequestBody Customer customer){
        if(authentication.register(customer)){
            return new ResponseEntity<>("Register Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>( "Register Unsuccessfully",HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/Logout")
    public ResponseEntity logout(){
        authentication.logout();
        return new ResponseEntity<>("Logout successfully", HttpStatus.OK);
    }


}
