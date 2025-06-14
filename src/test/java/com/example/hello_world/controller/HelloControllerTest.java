package com.example.hello_world.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void shouldReturnGreetingMessage() {
        String name = "Juan";

        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/v1/greeting")
                        .queryParam("name", name)
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.message").isEqualTo("Hello " + name + "!");
    }

    @Test
    void shouldHandleEmptyName() {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/v1/greeting")
                        .queryParam("name", "")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.message").isEqualTo("Hello !");
    }
}
