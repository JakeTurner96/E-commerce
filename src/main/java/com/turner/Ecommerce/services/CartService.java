package com.turner.Ecommerce.services;

import com.turner.Ecommerce.entities.Cart;
import com.turner.Ecommerce.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Cart getCartByAccountId(int accountId) {
        return cartRepository.findByCartOwner(accountId);
    }

    public Cart getCartById(int cartId) {
        return cartRepository.getOne(cartId);
    }

    public void addCart(Cart cart) {
        cartRepository.save(cart);
    }

    public boolean cartExistsByAccountId(int accountId) {
        return cartRepository.existsByCartOwner(accountId);
    }

    public List<Integer> getProductList(int accountId) {
        return cartRepository.getOne(accountId).getCartItems();
    }


}
