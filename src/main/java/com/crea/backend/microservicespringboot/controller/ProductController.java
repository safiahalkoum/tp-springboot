package com.crea.backend.microservicespringboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crea.backend.microservicespringboot.dao.ProductDao;
import com.crea.backend.microservicespringboot.model.Product;


@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping("/products")
    public List<Product> listProducts() {
        return productDao.findAll();
    }

    @RequestMapping(value="/addProducts", method=RequestMethod.POST)
    public void addProduct(@RequestBody Product product) {
        try{
            productDao.save(product);
        }catch(Exception e){
            throw e;
        }
        
    }

    @GetMapping("/product/{id}")
    public Optional<Product> searchById(@PathVariable int id) {
        return productDao.findById(id);
    }

    @GetMapping(value="/product/byName/{name}")
    public List<Product> searchByName(@PathVariable String name){
        return productDao.findByNameLike("%" + name + "%");
    }

    @GetMapping(value = "/product/highestPrice/{highPrice}")
    public List<Product> productHighPrice(@PathVariable int highPrice){
        return productDao.findByPriceGreaterThan(highPrice);
    }

    @GetMapping("/product/delete/{id}")
    public void findById(@PathVariable int id) {
        productDao.deleteById(id);
    }
}
