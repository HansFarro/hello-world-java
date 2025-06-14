package com.example.hello_world.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    @GetMapping("/greeting")
    public Mono<HashMap<String,String>> greeting(@RequestParam String name) {
        return Mono.just(new HashMap<String, String>() {{
            put("message", "Hello " + name + "!");
        }});
    }
}
