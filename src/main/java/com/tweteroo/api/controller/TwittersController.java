package com.tweteroo.api.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TwittesDTO;
import com.tweteroo.api.model.Twittes;
import com.tweteroo.api.model.Users;
import com.tweteroo.api.repository.TwitterRepository;
import com.tweteroo.api.repository.UserRepository;

@RestController
@RequestMapping("/twitters")
public class TwittersController {
    
    @Autowired
    private TwitterRepository TwRepository;
    @Autowired
    private UserRepository teste;

    @GetMapping
    public List<Twittes> getUsers() {
        /* System.out.println(TwRepository.findAll()); */
        return TwRepository.findAll();
    }

    @PostMapping
    public String postTwitters(@RequestBody TwittesDTO req) {

        Optional<Users> newUser = teste.findById(req.user_id());
        Users users = newUser.orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));
        TwRepository.save(new Twittes(req, users));
        return "Ok";
    }



}
