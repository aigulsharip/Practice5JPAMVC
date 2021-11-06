package com.example.practice3jpa.controllers;

import com.example.practice3jpa.entities.Product;
import com.example.practice3jpa.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/products")
@Controller

public class ProductController {
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping("/list")
    public String list(Model model) {
        //logger.info("Listing products");

        List<Product> products = productService.findAll();
        model.addAttribute("products", products);

        //logger.info("No. of products: " + products.size());

        return "products/list";
    }


}

