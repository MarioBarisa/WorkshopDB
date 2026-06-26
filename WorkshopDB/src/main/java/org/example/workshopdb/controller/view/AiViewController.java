package org.example.workshopdb.controller.view;

import org.example.workshopdb.service.OpenRouterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ai")
class AiViewController {

    private  final OpenRouterService openRouterService;

    public AiViewController(OpenRouterService openRouterService){
        this.openRouterService = openRouterService;
    }

    @GetMapping
    public String chatPage(Model model){
        model.addAttribute("question", "");
        model.addAttribute("answer","");
        return "ai/chat";
    }

    @PostMapping
    public String ask(@RequestParam String question, Model model){
        String answer = openRouterService.ask(question);
        model.addAttribute("question", question);
        model.addAttribute("answer", answer);
        return "ai/chat";
    }

}
