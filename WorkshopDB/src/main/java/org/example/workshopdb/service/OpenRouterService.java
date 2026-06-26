package org.example.workshopdb.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class OpenRouterService {

    @Value("${openrouter.api.key}")  // postaviti u appliaction-local.properties properties!
    private String apiKey;

    @Value("${openrouter.api.url}") // postaviti u appliaction-local.properties properties!
    private String url;

    private final WebClient webClient;

    public OpenRouterService(WebClient webClient){
        this.webClient = webClient;
    }

    public String ask(String question){
        Map<String, Object> body = Map.of(
                "model", "openrouter/free",
                "messeges", List.of(
                        Map.of("role", "system", "content",
                                "Ti si asistent u aplikaciji WorkshopDB koja ima za cilj pomoci mehanicarima u pračenju klijenta i njihovih automobila te sve vezano uz navedeno. " +
                                        "Uvjek odgovaraj na jeziku na kojem ti se postavi pitanje."+"Profesionaln i odgovori bez korištenja slang-a."
                        +"Odgovaraš na pitanja o klijentima, automobilima i popravcima."),
                        Map.of("role", "user", "content", "question")
                )
        );

        Map<?, ?> response = webClient.post()
                .uri(url)
                .header("Authorization", "Bearer"+apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        List<?> choices = (List<?>) response.get("choices");
        Map<?,?> first = (Map<?, ?>) choices.get(0);
        Map<?,?> message = (Map<?,?>) first.get("message");
        return (String) message.get("content");

    }
}
