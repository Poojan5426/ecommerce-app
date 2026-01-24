package com.example.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.ecommerce.entity.CartItem;

@Controller
@SessionAttributes("cart")
public class CartController {

    @ModelAttribute("cart")
    public List<CartItem> cart() {
        return new ArrayList<>();
    }

    
    @PostMapping("/addToCart")
    public String addToCart(@RequestParam Long id,
                            @RequestParam String name,
                            @RequestParam String price,
                            HttpSession session) {

        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        boolean found = false;
        for (CartItem item : cart) {
            if (item.getId() != null && item.getId().equals(id)) {  // safe null check
                item.setQuantity(item.getQuantity() + 1);
                found = true;
                break;
            }
        }

        if (!found) {
            CartItem item = new CartItem();
            item.setId(id);          // <-- must set ID
            item.setPrice(name);      // <-- must set name
            item.setPrice(price);    // <-- must set price
            item.setQuantity(1);
            cart.add(item);
        }

        session.setAttribute("cart", cart);
        return "redirect:/products";
    }


    @GetMapping("/cart")
    public String viewCart(@ModelAttribute("cart") List<CartItem> cart, Model model) {
        model.addAttribute("cart", cart);
        return "cart";
    }
}
