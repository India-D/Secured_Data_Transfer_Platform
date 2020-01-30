package com.masterpiece.securedDataPlatform.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Member extends AbstractEntity {
    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 20,nullable = false)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
