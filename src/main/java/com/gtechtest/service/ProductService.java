package com.gtechtest.service;

import com.gtechtest.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> findAll();
    Product findProduct(int productId);
}
