package com.crea.backend.microservicespringboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crea.backend.microservicespringboot.model.UserData;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserData, Integer> {
    List<UserData> findByUsernameLike(String name);
    UserData findByUsername(String name);
}
