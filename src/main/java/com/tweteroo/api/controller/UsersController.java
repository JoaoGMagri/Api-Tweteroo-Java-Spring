package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.model.Users;
import com.tweteroo.api.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UsersController {
    
    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<Users> getUsers() {
        return repository.findAll();
    }

    @PostMapping
    public void postUser(@RequestBody UserDTO req) {
        
        repository.save(new Users(req));
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserDTO req) {
        repository.findById(id).map( user -> {
            user.setName(req.name());
            user.setEmail(req.email());
            user.setPassword(req.password());

            return repository.save(user);
        });
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        repository.deleteById(id);
    }

}
