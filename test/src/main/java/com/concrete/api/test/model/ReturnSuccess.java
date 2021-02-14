package com.concrete.api.test.model;

import javax.persistence.Entity;
import java.time.OffsetDateTime;

public class ReturnSuccess {

    private String id;

    private OffsetDateTime created;

    private OffsetDateTime modified;

    private OffsetDateTime lastLogin;

    private String token;


    public ReturnSuccess(User userSaved)
    {
        this.id = userSaved.getId();
        this.created = userSaved.getCreated();
        this.modified = userSaved.getModified();
        this.lastLogin = userSaved.getLastLogin();
        this.token = userSaved.getToken();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
