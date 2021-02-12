package com.concrete.api.test.model;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
public class LoginRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "usuario_id")
    @OneToOne
    private User user;

    private OffsetDateTime created;

    private OffsetDateTime modified;

    private OffsetDateTime lastLogin;

    public LoginRegister()
    {
        super();
    }

    public LoginRegister(User usuario, OffsetDateTime created, OffsetDateTime modified, OffsetDateTime lastLogin) {
        super();
        this.user = usuario;
        this.created = created;
        this.modified = modified;
        this.lastLogin = lastLogin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
