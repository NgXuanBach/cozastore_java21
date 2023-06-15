package com.cybersoft.cozastore_java21.payload.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SignupRequest {
    private String username;

    @NotNull
    @NotEmpty
    @Length(min=8)
    private String password;
    @NotNull(message = "Email not null")
    @NotEmpty(message = "Email not empty")
    @Email(message = "Email invalid format")
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
