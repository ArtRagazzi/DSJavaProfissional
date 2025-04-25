package com.artragazzi.dscommerce.controllers;


import com.artragazzi.dscommerce.models.Product;
import com.artragazzi.dscommerce.repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping
    public Product getProduct(){
        Optional<Product> product = productRepository.findById(1L);
        Product myProd = product.get();
        return myProd;
    }

}
