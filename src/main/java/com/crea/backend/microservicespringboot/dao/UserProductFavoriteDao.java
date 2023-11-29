package com.crea.backend.microservicespringboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crea.backend.microservicespringboot.model.Product;
import com.crea.backend.microservicespringboot.model.UserData;
import com.crea.backend.microservicespringboot.model.UserProductFavorite;

public interface UserProductFavoriteDao extends JpaRepository<UserProductFavorite, Integer> {
    List<UserProductFavorite> findByUser(UserData user);
    List<UserProductFavorite> findByProduct(Product product);
}
