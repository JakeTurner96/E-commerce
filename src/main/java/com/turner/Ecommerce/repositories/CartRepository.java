package com.turner.Ecommerce.repositories;

import com.turner.Ecommerce.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    Cart findByCartOwner(int id);

    Boolean existsByCartOwner(int id);

}
