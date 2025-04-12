package com.example.YoRHa;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class WelcomeController {

    @GetMapping("/api/welcome")
    public String getWelcomeMessage() {
        return "Welcome to NieR-Trendz – Walk into the millennium! ";
    }
}
