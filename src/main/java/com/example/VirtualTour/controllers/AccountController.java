package com.example.VirtualTour.controllers;

import com.example.VirtualTour.entities.Account;
import com.example.VirtualTour.services.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(description = "Account Service")
@RestController
@RequestMapping("/")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

//    @PostMapping("/register")
//    public ResponseEntity<String> addAccount(@RequestBody Account account) {
//        Optional<Account> check = accountService.findAccount(account.getUsername());
//        if (!check.isPresent()) {
//            accountService.addAccount(account);
//            return new ResponseEntity<>("Successfully Registered", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Username already taken", HttpStatus.BAD_REQUEST);
//        }
//    }

    @ApiOperation( "login" )
    @PostMapping("/login")
    public ResponseEntity<String> findAccount(@RequestBody Account account) {
        Optional<Account> user = accountService.findAccount(account.getUsername());
        if (user.isPresent() && user.get().getPassword().equals(account.getPassword())) {
            return new ResponseEntity<>("Login Success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Login Failed", HttpStatus.UNAUTHORIZED);
        }
    }
}
