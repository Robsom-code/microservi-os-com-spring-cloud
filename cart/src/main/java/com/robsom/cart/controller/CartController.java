package com.robsom.cart.controller;

import com.robsom.cart.entity.Cart;
import com.robsom.cart.entity.Item;
import com.robsom.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;


    @PostMapping("/{id}")
    public Cart addItem(@PathVariable("id") Long id, @RequestBody Item item){
        Optional<Cart> savedCart = cartRepository.findById(id);
        Cart cart;

        if(savedCart.equals(Optional.empty())){
            cart = new Cart(id);
        }
        else{
            cart = savedCart.get();
        }

        cart.getItems().add(item);
        return cartRepository.save(cart);

    }

    @GetMapping("/{id}")
    public Optional<Cart>findById(@PathVariable("id")Long id){
        return cartRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable("id") Long id){
        cartRepository.deleteById(id);
    }



}
