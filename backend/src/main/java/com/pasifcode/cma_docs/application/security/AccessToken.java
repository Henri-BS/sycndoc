package com.pasifcode.cma_docs.application.security;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessToken {
    public String accessToken;

    public AccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @JsonProperty
    public String getAccessToken() {
        return accessToken;
    }

    @JsonProperty
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
