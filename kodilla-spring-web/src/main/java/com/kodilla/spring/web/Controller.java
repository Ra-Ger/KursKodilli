package com.kodilla.spring.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/check")
    public String checkStatus() {
        return "Server is running.";
    }
}
