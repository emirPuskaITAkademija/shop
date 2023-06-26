package com.beautiful.shop.product.service;

import com.beautiful.shop.product.entity.Product;
import com.beautiful.shop.product.entity.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();//SELECT * FROM products;
    }

    public void saveProduct(Product product){
        productRepository.save(product);
    }
}
