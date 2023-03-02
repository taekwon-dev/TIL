package com.youn.oauth.domain;

import com.youn.oauth.application.dto.OAuthProfileResponse;

public interface OAuthClient {

    String getAccessToken(String code);

    OAuthProfileResponse getGithubProfile(String githubAccessToken);
}