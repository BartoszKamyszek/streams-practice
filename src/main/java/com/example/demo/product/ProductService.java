package com.example.demo.product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> findProductByName(String name) {
        return null;
    }
}
