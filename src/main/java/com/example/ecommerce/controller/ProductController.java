package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository repo;

    @GetMapping("/products")
    public String products(@RequestParam(required = false) Double price, Model model) {
        List<Product> list = (price == null) ? repo.findAll() : repo.findByPriceLessThanEqual(price);
        model.addAttribute("products", list);
        return "products";
    }
}
