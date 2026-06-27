package org.example.workshopdb.controller.view;

import jakarta.validation.Valid;
import org.example.workshopdb.dto.AutoForm;
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
    public String list(@RequestParam(required = false) String search, Model model){
        List<Auto> autos = (search != null && !search.isBlank())
                ?
                autoRepository.findByMakeContainingIgnoreCaseOrModelContainingIgnoreCase(search, search)
                : autoRepository.findAll();

        model.addAttribute("autos", autos);
        model.addAttribute("search", search);
        return "cars/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model){
        model.addAttribute("autoForm", new AutoForm());
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("formTitle", "New car");
        model.addAttribute("formAction", "/cars");
        return "cars/form";
    }

    @PostMapping
    public String create(
            @Valid @ModelAttribute("autoForm") AutoForm form,
            BindingResult br,
            Model model,
            RedirectAttributes ra) {

        if (br.hasErrors()) {
            model.addAttribute("clients", clientRepository.findAll());
            model.addAttribute("formTitle", "New car.");
            model.addAttribute("formAction", "/cars");
            return "cars/form";
        }
        Auto a = new Auto();
        Client owner = clientRepository.findById(form.getClientId())
            .orElseThrow(() -> new IllegalArgumentException("Client does not exist."));
        a.setClient(owner);
        a.setMake(form.getMake());
        a.setModel(form.getModel());
        a.setVin(form.getVin());
        a.setEnginetype(form.getEnginetype());
        a.setEngine(form.getEngine());
        a.setPowerKW(form.getPowerKW());
        a.setYear(form.getYear());
        a.setMileage(form.getMileage());
        autoRepository.save(a);
        ra.addFlashAttribute("message", "Car added.");
        return "redirect:/cars";
    }


    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model){
        Auto a = autoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Car not found."));
        AutoForm form = new AutoForm();
        form.setClientId(a.getClient().getId());
        form.setMake(a.getMake());
        form.setModel(a.getModel());
        form.setVin(a.getVin());
        form.setEnginetype(a.getEnginetype());
        form.setEngine(a.getEngine());
        form.setPowerKW(a.getPowerKW());
        form.setYear(a.getYear());
        form.setMileage(a.getMileage());
        model.addAttribute("autoForm", form);
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("formTitle", "Edit car");
        model.addAttribute("formAction", "/cars/"+id);
        return "cars/form";
    }

    @PostMapping("/{id}")
    public String update(
            @PathVariable Integer id,
            @Valid @ModelAttribute("autoForm") AutoForm form,
            BindingResult br,
            Model model,
            RedirectAttributes ra) {

        if(br.hasErrors()){
            model.addAttribute("clients", clientRepository.findAll());
            model.addAttribute("formTitle", "Edit car");
            model.addAttribute("formAction", "/cars/"+id);
            return "cars/form";
        }
        Auto a = autoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Car not found."));
        Client owner = clientRepository.findById(form.getClientId())
                .orElseThrow(() -> new IllegalArgumentException("Client does not exist."));
        a.setClient(owner);
        a.setMake(form.getMake());
        a.setModel(form.getModel());
        a.setVin(form.getVin());
        a.setEnginetype(form.getEnginetype());
        a.setEngine(form.getEngine());
        a.setPowerKW(form.getPowerKW());
        a.setYear(form.getYear());
        a.setMileage(form.getMileage());
        autoRepository.save(a);
        ra.addFlashAttribute("message", "Car updated.");
        return "redirect:/cars";
    }

     @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes ra) {
        autoRepository.deleteById(id);
        ra.addFlashAttribute("message", "Car deleted.");
        return "redirect:/cars";
    }

}
