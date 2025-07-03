package com.ct.demo.controller;

import com.commercetools.api.models.product.ProductPagedQueryResponse;
import com.ct.demo.commercetools.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public CompletableFuture<ProductPagedQueryResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}
