package org.example.workshopdb.controller.view;

import jakarta.validation.Valid;
import org.example.workshopdb.dto.AutoForm;
import org.example.workshopdb.dto.ClientForm;
import org.example.workshopdb.entity.Auto;
import org.example.workshopdb.entity.Client;
import org.example.workshopdb.repository.AutoRepository;
import org.example.workshopdb.repository.ClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarViewController {

    private final AutoRepository autoRepository;
    private final ClientRepository clientRepository;


    public CarViewController(AutoRepository autoRepository, ClientRepository clientRepository) {
        this.autoRepository = autoRepository;
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public String list(@RequestBody(required = false) String search, Model model){
        List<Auto> autos = (search !=null || !search.isBlank())
                ?
                autoRepository.findByMakeContainingIgnoreCaseOrModelContainingIgnoreCase(search, search)
                : autoRepository.findAll();

        model.addAttribute("autos", autos);
        model.addAttribute("search", search);
        return "autos/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model){
        model.addAttribute("autoForm", new AutoForm());
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("formTitle", "New car");
        model.addAttribute("formAction", "/cars");
        return "cars/forms";
    }

    @PostMapping
    public String create(
            @Valid @ModelAttribute("autoForm") AutoForm form,
            BindingResult br,
            Model model,
            RedirectAttributes ra) {

        if (br.hasErrors()) {
            model.addAttribute("clients", clientRepository.findAll());
            model.addAttribute("formTitle", "Novi automobil");
            model.addAttribute("formAction", "/autos");
            return "autos/form";
        }
        Auto a = new Auto();
        Client owner = clientRepository.findById(form.getClientId())
            .orElseThrow(() -> new IllegalArgumentException("Klijent ne postoji."));
        a.setClient(owner);
        a.setMake(form.getMake());
        a.setModel(form.getModel());
        a.setVin(form.getVin());
        a.setEnginetype(form.getEnginetype());
        a.setEngine(form.getEngine());
        a.setKW(form.getKW());
        a.setYear(form.getYear());
        a.setMileage(form.getMileage());
        autoRepository.save(a);
        ra.addFlashAttribute("message", "Automobil uspješno dodan.");
        return "redirect:/autos";
    }


     @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes ra) {
        autoRepository.deleteById(id);
        ra.addFlashAttribute("message", "Automobil obrisan.");
        return "redirect:/autos";
    }

}
