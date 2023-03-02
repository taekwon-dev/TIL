package com.youn.oauth.presentation;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.UNDEFINED_PORT;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OAuthControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void init() {
        if (RestAssured.port == UNDEFINED_PORT) {
            RestAssured.port = port;
        }
    }

    @Test
    @DisplayName("[GET] 깃헙 로그인 페이지 요청")
    void github_login_page() {
        RestAssured.given().log().all()
                .when()
                .get("/api/authorization/github")
                .then()
                .log().body()
                .extract();
    }
}