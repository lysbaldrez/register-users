package com.concrete.api.test.controller;

import com.concrete.api.test.model.ReturnSuccess;
import com.concrete.api.test.model.User;
import com.concrete.api.test.repositories.UserRepository;
import exception.UnauthorizedToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import static java.util.concurrent.TimeUnit.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping(value = "/userprofile/{id}")
public class UserProfileController {

    @Autowired
    UserRepository userProfile;

    @Autowired
    HttpServletRequest request;

    @GetMapping(produces = { "application/json"}, headers = "Content-type=application/json")
    @ResponseStatus(HttpStatus.OK)
    public ReturnSuccess perfil(@PathVariable String id) throws UnauthorizedToken{
        String token;
        token = request.getHeader("Authorization");

        if (token == null || token.isEmpty ()) {
            throw new UnauthorizedToken("Não autorizado");
        }

        User user = new User();
        user = userProfile.findById(UUID.fromString(id));
        if (user == null || !user.getToken().equals(token)){
            throw new UnauthorizedToken("Não autorizado");
        }

        OffsetDateTime now = OffsetDateTime.now();
        long diff = ChronoUnit.MINUTES.between(user.getLastLogin(), now);
        if (diff >= 30) {
            throw new UnauthorizedToken("Não autorizado");
        }

        return new ReturnSuccess(user);

    }
}
