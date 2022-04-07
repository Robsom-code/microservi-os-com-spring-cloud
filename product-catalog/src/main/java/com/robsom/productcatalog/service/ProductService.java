package com.robsom.productcatalog.service;

import com.robsom.productcatalog.entity.Product;
import com.robsom.productcatalog.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product product){

        return productRepository.save(product);
    }



    public Optional<Product> getById(Long id){
        return productRepository.findById(id);
    }

}
