package com.turner.Ecommerce;

import com.turner.Ecommerce.entities.Account;
import com.turner.Ecommerce.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountDetailService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

//    static final String ROLE_PATRON = "PATRON";
//    static final String ROLE_ADMIN = "ADMIN";

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email);
        return User
                .withUsername(account.getEmail())
                .password(account.getPassword())
                .roles()
                .build();
    }

//    private String createRoles(Account.AccountType accountType) {
//        String role;
//        switch (accountType) {
//            case PATRON:
//                role = ROLE_PATRON;
//                break;
//            case ADMIN:
//                role = ROLE_ADMIN;
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + accountType);
//        }
//        return role;
//    }

}
