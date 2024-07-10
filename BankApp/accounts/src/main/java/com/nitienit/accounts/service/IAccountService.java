package com.nitienit.accounts.service;

import com.nitienit.accounts.dto.CustomerDetailsDto;
import com.nitienit.accounts.dto.CustomerDto;

public interface IAccountService {

    void createAccount(CustomerDto customerDto);

    CustomerDetailsDto fetchAccount(String mobileNo);

    boolean updateAccount(CustomerDetailsDto customerDetailsDto);

    boolean deleteAccount(String contactNo);
}
