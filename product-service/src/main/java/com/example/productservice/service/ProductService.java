package com.example.productservice.service;

import com.example.productservice.controller.Controller;
import com.example.productservice.dao.ProductDao;
import com.example.productservice.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductDao dao;

    public Controller.Product saveProduct(Controller.Product product) {
        Product entity = dao.save(Product.builder()
                                    .name(product.name())
                                    .category(product.category())
                                    .freshness(product.freshness())
                                    .price(product.price())
                                    .comment(product.comment())
                                    .date(product.date()).build());
        return new Controller.Product(
                entity.getId(),
                entity.getName(),
                entity.getCategory(),
                entity.getFreshness(),
                entity.getPrice(),
                entity.getComment(),
                entity.getDate());
    }

    public List<Controller.Product> getProducts() {
       return dao.findAll().stream()
               .map(p -> new Controller.Product(p.getId(),p.getName(),p.getCategory(),
                                                p.getFreshness(),p.getPrice(), p.getComment(),
                                                p.getDate()))
                                        .collect(Collectors.toList());
    }
}
