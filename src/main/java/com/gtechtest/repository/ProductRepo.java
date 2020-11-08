package com.gtechtest.repository;

import com.gtechtest.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface ProductRepo extends JpaRepository<Product, String> {
    @Query("SELECT x FROM Product x WHERE x.id = ?1")
    Product findOneById(int productId);
}
