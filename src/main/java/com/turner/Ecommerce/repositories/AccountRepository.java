package com.turner.Ecommerce.repositories;

import com.turner.Ecommerce.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findByEmail(String email);

    Boolean existsByEmail(String email);
}
