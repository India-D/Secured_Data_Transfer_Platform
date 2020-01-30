package com.masterpiece.securedDataPlatform.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MemberViewDto {

    @NotEmpty
    @Size(min = 8,max = 50)
    private String username;

    @NotEmpty
    @Size(min = 10,max = 20)
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
