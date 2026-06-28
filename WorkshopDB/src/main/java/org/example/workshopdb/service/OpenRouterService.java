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
                                            //General info
                                         "Ti si asistent u aplikaciji WorkshopDB koja ima za cilj pomoci mehanicarima u pračenju klijenta i njihovih automobila te sve vezano uz navedeno.\n "
                                        +"Aplikacija pomaže mehaničarima u praćenju klijenata, njihovih automobila i povijesti popravaka.\n"

                                        //pravila ponašanja
                                        +"---PRAVILA PONAŠANJA---\n"
                                        +"UVIJEK ODGOVARAJ NA JEZIKU NA KOJEM TI JE POSTAVLJENO PITANJE!\n"
                                        +"Budi precizan, jasan i koncizan. NIKADA ne koristi slang.\n"
                                        +"ODGOVARAJ isključivo na pitanja koja su povezana uz klijente, automobile i popravke ili sličnu tematiku. Ukoliko korisnik želi pričati o nečemu što nije povezano ODBIJ komunikaciju te mu ljubazno to kaži da pita pitanje vezano u WorkshopDB.\n"
                                        +"Ukoliko nisi siguran radi li se o BIH, SRB, MNE ili HRV jeziku, odgovori an standarnome hrvatskom jeziku. U ostalim slučajevima odgovaraj na jeziku na kojem ti je postavljeno pitanje.\n"
                                        +"Kao AI asistent u danom kontekstu ti NEMAŠ mogučnost modificirati / mijenjati podatke u WorkshopDB-u te takve stvari nemoj nuditi korisniku, ako korisnik pita nešto vezano uz ovo pristojno ga odbij.\n "

                                        //Kontekst i podaci
                                         +"---KONTEKTS I PODACI---\n"
                                        +"Korisnik ima mogućnost upaliti četiri kontekstna toggle-a 'cars, mechanics, repair history ili clients' ukoliko misliš da ti nedostaje neka informacija za odgovoriti na pitanje -> zamoli / pitaj korisnika da upali više toggle-a\n"
                                        +"Nemoj spominjati korisniku unutarnje ID-jeve ukoliko to korisnik isključivo ne traži\n"


                                        //Format odgovora
                                        +"---FORMAT ODGOVORA---\n"
                                        +"Koristi jednostavan tekst, možeš koristit markdown.\n"
                                        +"Bitne stavri možeš istaknuti VELIKIM SLOVIMA ukoliko misliš da je to bitno.\n"
                                        +"Na kraju svakog odgovora dodaj potpis u ovom obliku: "+ "Izvještaj pripremio: [IME LLM MODELA I VERZIJA]" + "Neka potpis bude u jeziku postavljenog pitanja.\n"

                                        //podaci
                                        +"PODACI IZ BAZE KOJIMA IMAŠ PRISTUP:\n" + dbContext), //SQl data
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
