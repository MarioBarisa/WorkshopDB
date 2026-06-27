package org.example.workshopdb.controller.view;

import org.example.workshopdb.service.AiContextJava;
import org.example.workshopdb.service.OpenRouterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ai")
public class AiViewController {
    private final OpenRouterService openRouterService;
    private final AiContextJava aiContextJava;

    public AiViewController(OpenRouterService openRouterService, AiContextJava aiContextJava){
        this.openRouterService = openRouterService;
        this.aiContextJava = aiContextJava;
    }

    @GetMapping
    public String chatPage(Model model){
        model.addAttribute("question", "");
        model.addAttribute("answer","");
        return "ai/chat";
    }

        @PostMapping
    public String ask(
        @RequestParam String question,
        @RequestParam(defaultValue = "false") boolean autos,
        @RequestParam(defaultValue = "false") boolean mechanics,
        @RequestParam(defaultValue = "false") boolean repairs,
        @RequestParam(defaultValue = "false") boolean clients,
        Model model
    ) {
        String context = aiContextJava.buildContext(autos, mechanics, repairs, clients);
        String answer = openRouterService.ask(question, context);
        model.addAttribute("question", question);
        model.addAttribute("answer", answer);
        model.addAttribute("autos", autos);
        model.addAttribute("mechanics", mechanics);
        model.addAttribute("repairs", repairs);
        model.addAttribute("clients", clients);
        return "ai/chat";
    }
}
