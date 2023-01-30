package com.example.productservice.controller;

import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class Controller {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    public record Product(int id, String name, String category, String freshness, Double price, String comment, LocalDate date){};
}
