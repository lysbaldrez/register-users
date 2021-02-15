package com.concrete.api.test.services;

import com.concrete.api.test.model.Login;
import com.concrete.api.test.model.User;
import com.concrete.api.test.repositories.UserRepository;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        User userExisting = userRepository.findByEmail(user.getEmail());

        if (userExisting != null && !userExisting.equals(user)) {
            System.out.printf("E-mail ja existente");
        }

        user.setCreated(OffsetDateTime.now());
        user.setLastLogin(OffsetDateTime.now());
        user.setModified(OffsetDateTime.now());

        TokenService tokenService = new TokenService();
        user.setToken(tokenService.generateToken(user));

        User userSaved = userRepository.save(user);
        return userSaved;
    }

    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }

    public User login(Login login) throws Exception {
        User userExisting = userRepository.findByEmail(login.getEmail());
        if (userExisting == null) {
            throw new Exception("Usuario e/ou senha invalidos");
        }

        return update(userExisting);
    }
}
