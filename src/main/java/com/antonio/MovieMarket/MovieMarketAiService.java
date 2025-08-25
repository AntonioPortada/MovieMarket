package com.antonio.MovieMarket;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface MovieMarketAiService {

    @UserMessage("""
            Genera un saludo de bienvenida, usa menos de 100 caracteres
            """)
    String generateGreeting();
}
