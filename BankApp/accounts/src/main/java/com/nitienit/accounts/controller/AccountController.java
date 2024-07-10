package com.nitienit.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nitienit.accounts.dto.CustomerDetailsDto;
import com.nitienit.accounts.dto.CustomerDto;
import com.nitienit.accounts.service.IAccountService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api")
public class AccountController {

    @Autowired
    private IAccountService iAccountService;

    @PostMapping("/create")
    public String createAccount(@RequestBody CustomerDto customerDto) {
        log.info("[AccountController] :: (createAccount) called");
        iAccountService.createAccount(customerDto);
        return "created successfully";
    }

    @GetMapping("{contactNo}")
    public CustomerDetailsDto getAccountDetail(@PathVariable String contactNo) {
        log.info("[AccountController] :: (getAccountDetail) called");
        CustomerDetailsDto customerDetailsDto = iAccountService.fetchAccount(contactNo);
        log.info("[AccountController] :: (getAccountDetail) fetch successfully ");
        return customerDetailsDto;
    }

    @PutMapping("/update")
    public boolean updateAccountDetails(@RequestBody CustomerDetailsDto customerDetailsDto) {
        log.info("[AccountController] :: (updateAccountDetails) called");
        return iAccountService.updateAccount(customerDetailsDto);
    }

    @DeleteMapping("{contactNo}")
    public boolean deleteAccount(@PathVariable(name = "contactNo") String contactNo) {
        log.info("[AccountController] :: (deleteAccount) called  contactNo {}", contactNo);
        return iAccountService.deleteAccount(contactNo);
    }
}
