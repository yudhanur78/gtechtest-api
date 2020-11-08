package com.gtechtest.controller;

import com.gtechtest.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.gtechtest.service.ProductService;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public Iterable<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping(path = "/{productCode}")
    public Product findProduct(@PathVariable("productCode") int productCode) {
        return productService.findProduct(productCode);
    }
}
