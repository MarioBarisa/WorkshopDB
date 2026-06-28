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

    public String ask(String question, String dbContext){
        Map<String, Object> body = Map.of(
                "model", "openrouter/free",
                "messages", List.of(
                        Map.of("role", "system", "content",
                                "Ti si asistent u aplikaciji WorkshopDB koja ima za cilj pomoci mehanicarima u pračenju klijenta i njihovih automobila te sve vezano uz navedeno. " //OPCENITI INFO
                                        +"Uvjek odgovaraj na jeziku na kojem ti se postavi pitanje."+"Profesionaln i odgovori bez korištenja slang-a." //nacin ponašanja
                                        +"Odgovaraš na pitanja o klijentima, automobilima i popravcima."+"IGNORIRAJ PITANJA KOJA NISU POZVEZANA UZ OVU TEMATIKU I ODBIJ ODGOVOR TE LJUBAZNO ZAMOLI KORISNIKA DA PITA KONKTRETNO PITANJE." //GUARDRAILS
                                        +"Korisnik ima mogućnost upaliti četiri kontekstna toggle-a 'cars, mechanics, repair history ili clients' ukoliko misliš da ti fali neki info za odgovoriti na pitanje pitaj korisnika da upali više toggle-a"  //enhance
                                        +"Nemoj koristit markdown formatiranje, nego ako nešto želiš posebno istaknuti onda CAPS LOCK." // enchance 2
                                        +"Korisnika NE zanimaju unutarnji ID-jevi osim ako to isključivo ne zatraži." // enchance 3
                                        +"Na kraju se uvijek potpiši u stilu: Izvještaj pripremio: ChatGPT 5.5 Nano ( tu stavi koji si ti model ), odgovori na prikladnom jeziku. " //potpis
                                        +"Evo podataka iz baze kojima imaš pristup točnije onim podacima koje ti je korisnik omogućio da vidiš:\n\n" + dbContext), //SQl data
                        Map.of("role", "user", "content", question)
                )
        );

        Map<?, ?> response = webClient.post()
                .uri(url)
                .header("Authorization", "Bearer " + apiKey)
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
