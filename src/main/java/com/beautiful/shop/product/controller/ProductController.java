package com.beautiful.shop.product.controller;

import com.beautiful.shop.product.entity.Product;
import com.beautiful.shop.product.entity.ProductRepository;
import com.beautiful.shop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String getProducts(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("proizvodi", products);
        return "product";
    }

    @GetMapping("/productPage")
    public String getProductPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize,Model model){
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Product> productPage = productRepository.findAll(pageable);
        model.addAttribute("productPage", productPage);
        return "productPage"; //productPage.html
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model){
        Product product = new Product();
        model.addAttribute("proizvod", product);
        return "add_product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("proizvod") Product product){
        productService.saveProduct(product);
        return "redirect:/products";
    }

}
