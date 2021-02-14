package com.concrete.api.test.model;

import javax.persistence.Entity;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public class ReturnSuccess {

    private String name;

    private String email;

    private String password;

    private List<Phone> phones;

    private UUID id;

    private OffsetDateTime created;

    private OffsetDateTime modified;

    private OffsetDateTime lastLogin;

    private String token;


    public ReturnSuccess(User userSaved)
    {
        this.name = userSaved.getName();
        this.email = userSaved.getEmail();
        this.password = userSaved.getPassword();
        this.phones = userSaved.getPhones();
        this.id = userSaved.getId();
        this.created = userSaved.getCreated();
        this.modified = userSaved.getModified();
        this.lastLogin = userSaved.getLastLogin();
        this.token = userSaved.getToken();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(OffsetDateTime created) {
        this.created = created;
    }

    public OffsetDateTime getModified() {
        return modified;
    }

    public void setModified(OffsetDateTime modified) {
        this.modified = modified;
    }

    public OffsetDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(OffsetDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
