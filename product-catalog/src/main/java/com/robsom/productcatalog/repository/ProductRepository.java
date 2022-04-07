package com.robsom.productcatalog.repository;

import com.robsom.productcatalog.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ProductRepository extends CrudRepository<Product,Long> {
}
