package com.turner.Ecommerce.controllers;

import com.turner.Ecommerce.entities.Product;
import com.turner.Ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class productsController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public String products(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

//    @RequestMapping()
//    public List<Product> getAllProducts() {
//        return productService.getAllProducts();
//    }
}
