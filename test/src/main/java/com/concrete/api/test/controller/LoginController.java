package com.concrete.api.test.controller;

import com.concrete.api.test.model.Login;
import com.concrete.api.test.model.ReturnSuccess;
import com.concrete.api.test.model.User;
import com.concrete.api.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping(produces = { "application/json"}, headers = "Content-type=application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ReturnSuccess login(@RequestBody Login login) throws Exception {

        User userLogin = userService.login(login);

        ReturnSuccess retornoSucesso = new ReturnSuccess(userLogin);

        return retornoSucesso;

    }
}
