package org.example.aitestpro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloword {

    @GetMapping(path = "/hello")
    String helloSpringboot(){
        return "Hello Spring Boot!";
    }
}
