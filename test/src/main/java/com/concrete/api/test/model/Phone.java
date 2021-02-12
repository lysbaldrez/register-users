package com.concrete.api.test.model;

import javax.persistence.*;

@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private String ddd;

    @OneToOne
    private User user;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public Phone(String number, String ddd, User user) {
        super();

        this.number = number;
        this.ddd = ddd;

    }

    public Phone() {
        super();
    }
}
