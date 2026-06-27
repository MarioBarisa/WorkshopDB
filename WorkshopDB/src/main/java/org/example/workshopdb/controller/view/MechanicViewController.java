package org.example.workshopdb.controller.view;

import jakarta.validation.Valid;
import org.example.workshopdb.dto.MechanicForm;
import org.example.workshopdb.entity.Mechanic;
import org.example.workshopdb.repository.MechanicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/mechanics")
public class MechanicViewController {

    private final MechanicRepository mechanicRepository;

    public MechanicViewController(MechanicRepository mechanicRepository) {
        this.mechanicRepository = mechanicRepository;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("mechanics", mechanicRepository.findAll());
        return "mechanics/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("mechanicForm", new MechanicForm());
        model.addAttribute("formTitle", "New Mechanic");
        model.addAttribute("formAction", "/mechanics");
        return "mechanics/form";
    }

    @PostMapping
    public String create(
            @Valid @ModelAttribute("mechanicForm") MechanicForm form,
            BindingResult br,
            Model model,
            RedirectAttributes ra) {

        if (br.hasErrors()) {
            model.addAttribute("formTitle", "New Mechanic");
            model.addAttribute("formAction", "/mechanics");
            return "mechanics/form";
        }
        Mechanic m = new Mechanic();
        m.setName(form.getName());
        m.setPhone(form.getPhone());
        mechanicRepository.save(m);
        ra.addFlashAttribute("message", "Mechanic added.");
        return "redirect:/mechanics";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Mechanic m = mechanicRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Mechanic not found."));
        MechanicForm form = new MechanicForm();
        form.setName(m.getName());
        form.setPhone(m.getPhone());
        model.addAttribute("mechanicForm", form);
        model.addAttribute("formTitle", "Edit Mechanic");
        model.addAttribute("formAction", "/mechanics/" + id);
        return "mechanics/form";
    }

    @PostMapping("/{id}")
    public String update(
            @PathVariable Integer id,
            @Valid @ModelAttribute("mechanicForm") MechanicForm form,
            BindingResult br,
            Model model,
            RedirectAttributes ra) {

        if (br.hasErrors()) {
            model.addAttribute("formTitle", "Edit Mechanic");
            model.addAttribute("formAction", "/mechanics/" + id);
            return "mechanics/form";
        }
        Mechanic m = mechanicRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Mechanic not found."));
        m.setName(form.getName());
        m.setPhone(form.getPhone());
        mechanicRepository.save(m);
        ra.addFlashAttribute("message", "Mechanic updated.");
        return "redirect:/mechanics";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes ra) {
        mechanicRepository.deleteById(id);
        ra.addFlashAttribute("message", "Mechanic deleted.");
        return "redirect:/mechanics";
    }
}
