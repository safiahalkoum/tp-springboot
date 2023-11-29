package com.crea.backend.microservicespringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crea.backend.microservicespringboot.dao.ProductDao;
import com.crea.backend.microservicespringboot.dao.UserDao;
import com.crea.backend.microservicespringboot.dao.UserProductFavoriteDao;
import com.crea.backend.microservicespringboot.model.Product;
import com.crea.backend.microservicespringboot.model.UserData;
import com.crea.backend.microservicespringboot.model.UserProductFavorite;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/favorites")
public class UserProductFavoriteDaoController {
    @Autowired
    private UserProductFavoriteDao userProductFavoriteDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    // Get favorites of a specific user
    @GetMapping("/user/{userId}")
    public List<Product> getUserFavorites(@PathVariable Integer userId) {
        UserData user = userDao.findById(userId).orElse(null);
        List<UserProductFavorite> userProductFavorites = userProductFavoriteDao.findByUser(user);
        return userProductFavorites.stream()
                .map(UserProductFavorite::getProduct)
                .collect(Collectors.toList());
    }

    // Get favorites of a specific product
    @GetMapping("/product/{productId}")
    public List<UserData> getProductFavorites(@PathVariable Integer productId) {
        Product product = productDao.findById(productId).orElse(null);
        List<UserProductFavorite> productFavorites = userProductFavoriteDao.findByProduct(product);
        return productFavorites.stream()
                .map(UserProductFavorite::getUser)
                .collect(Collectors.toList());
    }

    // Get all users with their favorites
    @GetMapping("/users")
    public List<Map<String, Object>> getAllUsersWithFavorites() {
        List<UserData> users = userDao.findAll();
        return users.stream()
                .map(user -> {
                    Map<String, Object> result = new HashMap<>();
                    result.put("user", user);
                    result.put("favorites", userProductFavoriteDao.findByUser(user).stream()
                            .map(UserProductFavorite::getProduct)
                            .collect(Collectors.toList()));
                    return result;
                })
                .collect(Collectors.toList());
    }

    // Get all products with their users
    @GetMapping("/products")
    public List<Map<String, Object>> getAllProductsWithUsers() {
        List<Product> products = productDao.findAll();
        return products.stream()
                .map(product -> {
                    Map<String, Object> result = new HashMap<>();
                    result.put("product", product);
                    result.put("users", userProductFavoriteDao.findByProduct(product).stream()
                            .map(UserProductFavorite::getUser)
                            .collect(Collectors.toList()));
                    return result;
                })
                .collect(Collectors.toList());
    }
}

