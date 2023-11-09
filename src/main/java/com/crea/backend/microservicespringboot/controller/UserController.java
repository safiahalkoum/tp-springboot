package com.crea.backend.microservicespringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crea.backend.microservicespringboot.dao.UserDao;
import com.crea.backend.microservicespringboot.model.UserData;


@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/users")
    public List<UserData> listUsers() {
        return userDao.findAll();
    }


    @RequestMapping(value="/register", method=RequestMethod.POST)
    public void register(@RequestBody UserData user) {
        try{
            userDao.save(user);
        }catch(Exception e){
            throw e;
        }
        
    }


    @PostMapping("/login")
    public UserData loginUser(@RequestBody UserData user) {
        // Recherche de l'utilisateur par le nom d'utilisateur dans la base de données
        UserData existingUser = userDao.findByUsername(user.getUsername());

        // Vérification du mot de passe
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            // Mot de passe correct, retourne l'utilisateur
            return existingUser;
        } else {
            // Mot de passe incorrect, retourne null
            return null;
        }
    }

    @GetMapping("/user/{id}")
    public Optional<UserData> searchById(@PathVariable int id) {
        return userDao.findById(id);
    }

    @GetMapping(value="/user/byUsername/{username}")
    public List<UserData> searchByUsername(@PathVariable String username){
        return userDao.findByUsernameLike("%" + username + "%");
    }

    @GetMapping("/user/delete/{id}")
    public void findById(@PathVariable int id) {
        userDao.deleteById(id);
    }
}
