package com.concrete.api.test.model;

import java.time.OffsetDateTime;

public class ReturnSuccess {

    private String id;

    private OffsetDateTime created;

    private OffsetDateTime modified;

    private OffsetDateTime lastLogin;


    public ReturnSuccess(User userSaved)
    {
        this.id = userSaved.getId();
        this.created = userSaved.getCreated();
        this.modified = userSaved.getModified();
        this.lastLogin = userSaved.getLastLogin();
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
}
