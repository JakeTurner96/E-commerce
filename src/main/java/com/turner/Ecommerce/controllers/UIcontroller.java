package com.turner.Ecommerce.controllers;

import com.turner.Ecommerce.entities.Account;
import com.turner.Ecommerce.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIcontroller {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/registerAccount")
    public String registerAccount(Account account) {
        accountService.addAccount(account);
        return "redirect:/register";
    }

}
