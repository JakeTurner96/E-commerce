package com.turner.Ecommerce.controllers;

import com.turner.Ecommerce.entities.Account;
import com.turner.Ecommerce.entities.Cart;
import com.turner.Ecommerce.services.AccountService;
import com.turner.Ecommerce.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private AccountService accountService;


    @RequestMapping("/addToCart/{productId}")
    @ResponseBody
    public String addToCart(@PathVariable Integer productId) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Account account = accountService.getAccountByEmail(email);

        if (cartService.cartExistsByAccountId(account.getId())) {
            Cart cart = cartService.getCartByAccountId(account.getId());
            ArrayList<Integer> cartList = cart.getCartItems();
            cartList.add(productId);

            cart.setCartItems(cartList);

            cartService.addCart(cart);

        } else if (!cartService.cartExistsByAccountId(account.getId())) {

            ArrayList<Integer> cartList = new ArrayList<>();
            cartList.add(productId);

            Cart cart = new Cart();
            cart.setCartOwner(account.getId());
            cart.setCartSize(1);
            cart.setCartItems(cartList);
            cartService.addCart(cart);
        }

        System.out.println(cartService.getCartByAccountId(account.getId()));
        return "redirect:/products";
    }
}
