package com.turner.Ecommerce.controllers;

import com.turner.Ecommerce.entities.Account;
import com.turner.Ecommerce.entities.ChangePasswordRequest;
import com.turner.Ecommerce.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
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
    public String myAccount(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        Account authenticatedAccount = accountService.getAccountByEmail(email);
        model.addAttribute("account", authenticatedAccount);

        return "myAccount";
    }

    @RequestMapping("/deleteAccount")
    public String deleteAccount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Account account = accountService.getAccountByEmail(email);
        accountService.deleteAccount(account);
        return "redirect:/logout";
    }

    @RequestMapping("/updateAccount")
    public String updateAccount(Account updatedAccount) {
        Account oldAccount = accountService.getAccountByEmail(updatedAccount.getEmail());

        oldAccount.setEmail(updatedAccount.getEmail());
        oldAccount.setFirstName(updatedAccount.getFirstName());
        oldAccount.setLastName(updatedAccount.getLastName());
        oldAccount.setDob(updatedAccount.getDob());
        oldAccount.setMobileNumber(updatedAccount.getMobileNumber());

        accountService.addAccount(oldAccount);

        return "redirect:/myAccount";
    }

    @RequestMapping("/changePassword")
    public String changePassword(Model model) {
        return "changePassword";
    }

//    @RequestMapping("/updatePassword")
//    public String updatePassword(@RequestParam("newPassword") String newPassword, @RequestParam("oldPassword") String oldPassword, Model model) {
//        Account account = accountService.getAccountByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
//
//        if (account.getPassword().equals(oldPassword)) {
//            account.setPassword(newPassword);
//            accountService.addAccount(account);
//            model.addAttribute("msg", "Password updated");
//        }
//
//        System.out.println(model.asMap().size());
//        return "redirect:/changePassword";
//    }

    @RequestMapping("/updatePassword")
    public String updatePassword(ChangePasswordRequest changePasswordRequest, Model model) {
        Account account = accountService.getAccountByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        String msg = "";

        if (account.getPassword().equals(changePasswordRequest.getOldPassword())) {
            account.setPassword(changePasswordRequest.getNewPassword());
            accountService.addAccount(account);
            msg = "Password updated";

        } else if (!account.getPassword().equals(changePasswordRequest.getOldPassword())) {
            msg = "Password failed to update";
        }
        model.addAttribute("msg", msg);
        return "/changePassword";
    }


}
