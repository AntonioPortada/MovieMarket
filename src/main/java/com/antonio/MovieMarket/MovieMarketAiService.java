package com.antonio.MovieMarket;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface MovieMarketAiService {

    @UserMessage("""
            Genera un saludo de bienvenida, usa menos de 100 caracteres, 
            para {{platform}}
            """)
    String generateGreeting(@V("platform") String platform);
}
