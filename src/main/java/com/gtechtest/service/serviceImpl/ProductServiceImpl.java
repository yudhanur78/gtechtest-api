package com.gtechtest.service.serviceImpl;

import com.gtechtest.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gtechtest.repository.ProductRepo;
import com.gtechtest.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public Product findProduct(int productId) {
        return productRepo.findOneById(productId);
    }
}
