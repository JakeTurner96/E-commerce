package com.turner.Ecommerce.entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Data
@Table(name = "CART")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    @NotNull
    private int cartSize;

    @NotNull
    private ArrayList<Integer> cartItems;

    @NotNull
    private int cartOwner;

}
