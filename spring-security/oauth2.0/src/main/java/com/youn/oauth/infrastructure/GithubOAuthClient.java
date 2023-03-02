package com.youn.oauth.infrastructure;

import com.youn.oauth.application.dto.OAuthProfileResponse;
import com.youn.oauth.domain.OAuthClient;
import com.youn.oauth.infrastructure.dto.OAuthAccessTokenRequest;
import com.youn.oauth.infrastructure.dto.OAuthAccessTokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GithubOAuthClient implements OAuthClient {

    private static final String ACCESS_TOKEN_URL_SUFFIX = "/login/oauth/access_token";

    private final String clientId;
    private final String clientSecret;
    private final String oauthBaseUrl;
    private final String apiBaseUrl;

    public GithubOAuthClient(
        @Value("${security.github.client.id}") String clientId,
        @Value("${security.github.client.secret}") String clientSecret,
        @Value("${security.github.url.oauth}") String oauthBaseUrl,
        @Value("${security.github.url.api}") String apiBaseUrl
    ) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.oauthBaseUrl = oauthBaseUrl;
        this.apiBaseUrl = apiBaseUrl;
    }

    @Override
    public String getAccessToken(String code) {
        OAuthAccessTokenRequest githubAccessTokenRequest = new OAuthAccessTokenRequest(clientId, clientSecret, code);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<OAuthAccessTokenRequest> httpEntity = new HttpEntity<>(githubAccessTokenRequest, headers);
        String accessTokenUrl = oauthBaseUrl + ACCESS_TOKEN_URL_SUFFIX;

        OAuthAccessTokenResponse response = new RestTemplate()
                .exchange(accessTokenUrl, HttpMethod.POST, httpEntity, OAuthAccessTokenResponse.class)
                .getBody();

        return response.getAccessToken();
    }

    @Override
    public OAuthProfileResponse getGithubProfile(String githubAccessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Authorization", "Bearer " + githubAccessToken);
        HttpEntity<Void> httpEntity = new HttpEntity<>(headers);
        String url = apiBaseUrl + "/user";
        return new RestTemplate()
                .exchange(url, HttpMethod.GET, httpEntity, OAuthProfileResponse.class)
                .getBody();
    }
}