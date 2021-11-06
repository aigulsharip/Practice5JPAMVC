package com.example.practice3jpa.controllers;

import com.example.practice3jpa.entities.Product;
import com.example.practice3jpa.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/products")
public class ProductController {
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Product> getProducts() {
        return productService.findAll();
    }

    //@GetMapping()
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String list(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products/list";
    }


    /*
    @RequestMapping(method = RequestMethod.GET, value = "/results")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.findAll();
        //model.addAttribute("products", products);

        modelAndView.addAllObjects("products", products);
        modelAndView.setViewName("login.html");
        return modelAndView;
    }
    /*

    @GetMapping("{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.findProductById(id));
        return "products/show";
    }

     */



}

