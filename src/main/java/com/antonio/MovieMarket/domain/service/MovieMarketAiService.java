package com.antonio.MovieMarket.domain.service;

import dev.langchain4j.service.SystemMessage;
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

    @SystemMessage("""
            Eres un experto en cine que recomienda películas  personalizadas segun los gustos del
            usuario. Debes recomendar máximo 3 películas. No incluyas películas por fuera de MovieMarket.
            """)
    String generateMovieSugestions(@UserMessage String userMessage);
}
