package com.robsom.productcatalog.controller;

import com.robsom.productcatalog.entity.Product;

import com.robsom.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return productService.createProduct(product);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product>getByID(@PathVariable ("id") Long id)throws Exception{
        return ResponseEntity.ok(productService.getById(id).orElseThrow(() -> new NoSuchElementException("Id não encontrado")));
    }


}
