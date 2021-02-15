package com.concrete.api.test.controller;

import com.concrete.api.test.model.ReturnSuccess;
import com.concrete.api.test.model.User;
import com.concrete.api.test.repositories.UserRepository;
import com.concrete.api.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping(produces = { "application/json"}, headers = "Content-type=application/json")
    public List<User> listar() {
        return userRepository.findAll();
    }


    @PostMapping(produces = { "application/json"}, headers = "Content-type=application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ReturnSuccess adicionar(@Valid @RequestBody User user) {
        User userSaved = userService.save(user);
        return new ReturnSuccess(userSaved);

    }
}
