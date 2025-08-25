package com.antonio.MovieMarket.web.controller;

import com.antonio.MovieMarket.domain.service.MovieMarketAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final String platform;
    private final MovieMarketAiService iaService;

    public HelloController(@Value("${spring.application.name}") String platform, MovieMarketAiService iaService) {
        this.platform = platform;
        this.iaService = iaService;
    }

    @GetMapping("/hello")
    public String hello() {
        return iaService.generateGreeting(platform);
    }
}
