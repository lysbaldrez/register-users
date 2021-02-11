package com.concrete.api.test.services;

import com.concrete.api.test.model.Login;
import com.concrete.api.test.model.LoginRegister;
import com.concrete.api.test.model.User;
import com.concrete.api.test.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public LoginRegister save (User user) {

        LoginRegister login = new LoginRegister();

        login.setUser(user);
        login.setCreated(OffsetDateTime.now());
        login.setLastLogin(OffsetDateTime.now());

        return loginRepository.save(login);

    }
}
