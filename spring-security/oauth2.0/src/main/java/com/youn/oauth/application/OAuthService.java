package com.youn.oauth.application;

import com.youn.oauth.application.dto.OAuthProfileResponse;
import com.youn.oauth.application.dto.TokenDto;
import com.youn.oauth.infrastructure.GithubOAuthClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthService {

    private final GithubOAuthClient githubOAuthClient;

    public TokenDto createToken(String code) {
        String githubAccessToken = githubOAuthClient.getAccessToken(code);
        OAuthProfileResponse githubProfileResponse = githubOAuthClient.getGithubProfile(githubAccessToken);
        String token = "JWT Access Token";
        return new TokenDto(token, githubProfileResponse.getUsername());
    }
}