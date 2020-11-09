package com.turner.Ecommerce.services;

import com.turner.Ecommerce.entities.Account;
import com.turner.Ecommerce.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountById(int id) {
        return accountRepository.getOne(id);
    }

    public Account getAccountByEmail(String email){return accountRepository.findByEmail(email);}

    public void addAccount(Account account) {
        accountRepository.save(account);
    }

    public void deleteAccount(Account account){accountRepository.delete(account);}

}
