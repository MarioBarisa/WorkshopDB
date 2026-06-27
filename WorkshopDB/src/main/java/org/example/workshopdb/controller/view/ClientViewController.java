package org.example.workshopdb.controller.view;

import jakarta.validation.Valid;
import org.example.workshopdb.dto.ClientForm;
import org.example.workshopdb.entity.Client;
import org.example.workshopdb.repository.AutoRepository;
import org.example.workshopdb.service.ClientView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/clients")
public class ClientViewController {

    private final ClientView service;
    private final AutoRepository autoRepository;

    ClientViewController(ClientView service, AutoRepository autoRepository) {
        this.service = service;
        this.autoRepository = autoRepository;
    }

    // GET /clients?search=Pero
    @GetMapping
    public String list(@RequestParam(required = false) String search, Model model){
        model.addAttribute("clients", service.search(search));
        model.addAttribute("search", search);
        return "clients/list";
    }

     // GET /clients/{id}
    @GetMapping("/{id}")
    public String details(@PathVariable Integer id, Model model){
        model.addAttribute("client", service.findByID(id));
        model.addAttribute("autos", autoRepository.findByClient_Id(id));
        return "clients/details";
    }

    //GET /clienst/new
    @GetMapping("/new")
    public String showCreateForm(Model model){
        model.addAttribute("clientForm", new ClientForm());
        model.addAttribute("formTitle", "New Client");
        model.addAttribute("formAction", "/clients");
        return "clients/form";
    }

    //POST /clients
    @PostMapping
    public String create(
            @Valid @ModelAttribute("clientForm")ClientForm clientForm,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes
            ){
        if(bindingResult.hasErrors()){
            model.addAttribute("formTitle", "New client");
            model.addAttribute("formAction", "/clients");
            return "clients/form";
        }
        service.save(clientForm);
        redirectAttributes.addFlashAttribute("message", "Client added!");
        return "redirect:/clients";
    }

    //GET /clients/{id}/edit
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model){
        Client c = service.findByID(id);
        model.addAttribute("clientForm", service.toForm(c));
        model.addAttribute("formTitle", "Edit client.");
        model.addAttribute("formAction", "/clients/"+id);
        return  "clients/form";
    }

     // /POST /clients/{id} TREBA IMPLEMENTIRATI
    @PostMapping("/{id}")
    public String update(
            @PathVariable Integer id,
            @Valid @ModelAttribute("clientForm") ClientForm form,
            BindingResult br,
            Model model,
            RedirectAttributes ra) {

        if (br.hasErrors()) {
            model.addAttribute("clientId", id);
            model.addAttribute("formTitle", "Uredi klijenta");
            model.addAttribute("formAction", "/clients/" + id);
            return "clients/form";
        }
        service.update(id, form);
        ra.addFlashAttribute("message", "Klijent uspješno ažuriran.");
        return "redirect:/clients";
    }

    // POST /clients/{id}/delete
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes ra) {
        service.delete(id);
        ra.addFlashAttribute("message", "Klijent obrisan.");
        return "redirect:/clients";
    }
}

