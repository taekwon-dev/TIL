package com.youn.oauth.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OAuthProfileResponse {

    @JsonProperty("login")
    private String username;

    private OAuthProfileResponse() {
    }

    public OAuthProfileResponse(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}