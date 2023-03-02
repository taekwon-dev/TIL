package com.youn.oauth.presentation;

import com.youn.oauth.application.OAuthService;
import com.youn.oauth.application.dto.TokenDto;
import com.youn.oauth.presentation.dto.OAuthTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class OAuthController {

    private final OAuthService oauthService;

    @GetMapping("/afterlogin")
    public ResponseEntity<OAuthTokenResponse> afterAuthorizeGithubLogin(@RequestParam String code) {
        TokenDto tokenDto = oauthService.createToken(code);
        return ResponseEntity
                .ok()
                .body(new OAuthTokenResponse(tokenDto.getToken(), tokenDto.getUsername()));
    }
}