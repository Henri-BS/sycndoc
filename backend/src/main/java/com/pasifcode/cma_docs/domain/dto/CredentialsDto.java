package com.pasifcode.cma_docs.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CredentialsDto {
    private String email;
    private String password;

    public CredentialsDto() {
    }

    public String getEmail() {
        return email;
    }

    @JsonProperty
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }
}
