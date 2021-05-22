package com.example.kafa.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@Profile("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ServiceControllerTest {

    @Autowired
    private WebTestClient client;

    private static String URL = "http://localhost:8080";

    @Test
    void sendMessage() {
        client.post().uri(URL + "/kafka/publish?message=AmazingWorld")
                .accept(MediaType.APPLICATION_JSON)
                .exchange().expectStatus().isEqualTo(200);
    }
}