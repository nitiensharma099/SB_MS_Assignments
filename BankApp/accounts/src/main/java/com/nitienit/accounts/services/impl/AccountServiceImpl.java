package com.nitienit.accounts.services.impl;

import java.util.Random;

import com.nitienit.accounts.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitienit.accounts.dto.AccountDto;
import com.nitienit.accounts.dto.CustomerDetailsDto;
import com.nitienit.accounts.dto.CustomerDto;
import com.nitienit.accounts.entites.Account;
import com.nitienit.accounts.entites.Customer;
import com.nitienit.accounts.repository.AccountRepository;
import com.nitienit.accounts.repository.CustomerRepository;
import com.nitienit.accounts.service.IAccountService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {

        long accountNo = 10000L + new Random().nextInt(999999);
        log.info("[AccountServiceImpl]:: (createAccount) started {}", accountNo);
        var dbCustomer = createCustomer(customerDto);
        log.info("[AccountServiceImpl]:: (createCustomer) started--{}", dbCustomer.getCustomerId());
        Account account = new Account();
        account.setCustomerId(dbCustomer.getCustomerId());
        account.setAccountNo(accountNo);
        account.setAccountType("SAVING");
        account.setBranchName("HDFC BRNACH");
        account.setBranchAddress("Crossing Republic Ghaziabad");
        accountRepository.save(account);

    }

    public Customer createCustomer(CustomerDto customerDto) {
        log.info("[AccountServiceImpl]:: (createCustomer) started");
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        return customerRepository.save(customer);

    }

    @Override
    public CustomerDetailsDto fetchAccount(String contactNo) {
        log.info("[AccountServiceImpl]:: (fetchAccount) started  contactNo={}", contactNo);
        Customer dbCustomerDetails = customerRepository.findByContactNo(contactNo)
                .orElseThrow(() -> new RuntimeException("Resource Not Found"));
        log.info("[AccountServiceImpl]:: (fetchAccount) dbCustomerDetails.getCustomerId()=  {}", dbCustomerDetails.getCustomerId());
        Account dbAccountDetails = accountRepository.findByCustomerId(dbCustomerDetails.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Resource Not Found"));

        CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto();
        BeanUtils.copyProperties(dbCustomerDetails, customerDetailsDto);

        AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(dbAccountDetails, accountDto);

        customerDetailsDto.setAccountDto(accountDto);
        log.info("[AccountServiceImpl]:: (fetchAccount) ends");
        return customerDetailsDto;
    }

    @Override
    public boolean updateAccount(CustomerDetailsDto customerDetailsDto) {
        log.info("[AccountServiceImpl]:: (updateAccount) started  {}", customerDetailsDto.getName());
        AccountDto accountDto = customerDetailsDto.getAccountDto();
        log.info("[AccountServiceImpl]:: getAccountNo  {}", accountDto.getAccountNo());
        if (accountDto != null) {
            Account account = accountRepository.findById(accountDto.getAccountNo()).orElseThrow(() -> new ResourceNotFoundException("Account doest not exist"));

            BeanUtils.copyProperties(accountDto, account);
            accountRepository.save(account);

            Customer dbcustomer = customerRepository.findById(account.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Customer doest exist with this account"));
            BeanUtils.copyProperties(customerDetailsDto, dbcustomer);
            customerRepository.save(dbcustomer);
            return true;
        } else {
            throw new RuntimeException("Account doest not exist");
        }
    }

    @Override
    public boolean deleteAccount(String contactNo) {
        log.info("[AccountServiceImpl]:: (deleteAccount) started  ");
        Customer dbCustomerDetails = customerRepository.findByContactNo(contactNo)
                .orElseThrow(() -> new RuntimeException("Contact Not Found"));
        accountRepository.deleteByCustomerId(dbCustomerDetails.getCustomerId());
        customerRepository.deleteById(dbCustomerDetails.getCustomerId());
        return true;
    }

}
