package com.turner.Ecommerce.controllers;

import com.turner.Ecommerce.entities.Account;
import com.turner.Ecommerce.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/registerAccount")
    public String registerAccount(Account account) {

        account.setAccountOpened(LocalDate.now());
        accountService.addAccount(account);
        return "redirect:/register";
    }

    @RequestMapping("/myAccount")
    public String myAccount(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        Account authenticatedAccount = accountService.getAccountByEmail(email);
        model.addAttribute("account", authenticatedAccount);

        return "myAccount";
    }

    @RequestMapping("/deleteAccount")
    public String deleteAccount(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Account account = accountService.getAccountByEmail(email);
        accountService.deleteAccount(account);

        return "redirect:/logout";
    }

}
