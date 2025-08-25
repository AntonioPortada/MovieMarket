package com.antonio.MovieMarket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final MovieMarketAiService iaService;

    public HelloController(MovieMarketAiService iaService) {
        this.iaService = iaService;
    }

    @GetMapping("/")
    public String hello() {
        return iaService.generateGreeting();
    }
}
