package com.crea.backend.microservicespringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.crea.backend.microservicespringboot.model.Product;
import com.crea.backend.microservicespringboot.model.UserProductFavorite;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
    List<Product> findByNameLike(String name);
    List<Product> findByPriceGreaterThan(int limitPrice);
}
