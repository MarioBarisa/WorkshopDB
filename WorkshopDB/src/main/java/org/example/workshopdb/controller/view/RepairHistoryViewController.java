package org.example.workshopdb.controller.view;

import jakarta.validation.Valid;
import org.example.workshopdb.dto.RepairHistoryForm;
import org.example.workshopdb.entity.Auto;
import org.example.workshopdb.entity.Mechanic;
import org.example.workshopdb.entity.RepairHistory;
import org.example.workshopdb.repository.AutoRepository;
import org.example.workshopdb.repository.MechanicRepository;
import org.example.workshopdb.repository.RepairHistoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/repairs")
public class RepairHistoryViewController {

    private final RepairHistoryRepository repairHistoryRepository;
    private final AutoRepository autoRepository;
    private final MechanicRepository mechanicRepository;

    RepairHistoryViewController(RepairHistoryRepository repairHistoryRepository, AutoRepository autoRepository, MechanicRepository mechanicRepository) {
        this.repairHistoryRepository = repairHistoryRepository;
        this.autoRepository = autoRepository;
        this.mechanicRepository = mechanicRepository;
    }

    @GetMapping
    public String list(Model model){
        List<RepairHistory> repairs = repairHistoryRepository.findAll();
        model.addAttribute("repairs", repairs);
        return "repairhistory/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model){
        model.addAttribute("repairForm", new RepairHistoryForm());
        model.addAttribute("autos", autoRepository.findAll());
        model.addAttribute("mechanics", mechanicRepository.findAll());
        model.addAttribute("formTitle", "New Repair");
        model.addAttribute("formAction", "/repairs");
        return "repairhistory/form";
    }

    @PostMapping
    public String create(
            @Valid @ModelAttribute("repairForm") RepairHistoryForm form,
            BindingResult br,
            Model model,
            RedirectAttributes ra) {

        if(br.hasErrors()){
            model.addAttribute("autos", autoRepository.findAll());
            model.addAttribute("mechanics", mechanicRepository.findAll());
            model.addAttribute("formTitle", "New Repair");
            model.addAttribute("formAction", "/repairs");
            return "repairhistory/form";
        }
        RepairHistory r = new RepairHistory();
        Auto a = autoRepository.findById(form.getAutoId())
                .orElseThrow(() -> new IllegalArgumentException("Auto not found."));
        Mechanic m = mechanicRepository.findById(form.getMechanicId())
                .orElseThrow(() -> new IllegalArgumentException("Mechanic not found."));
        r.setAuto(a);
        r.setMechanic(m);
        r.setDate(form.getDate());
        r.setTitle(form.getTitle());
        r.setAbout(form.getAbout());
        r.setPrice(form.getPrice());
        repairHistoryRepository.save(r);
        ra.addFlashAttribute("message", "Repair added.");
        return "redirect:/repairs";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model){
        RepairHistory r = repairHistoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Repair not found."));
        RepairHistoryForm form = new RepairHistoryForm();
        form.setAutoId(r.getAuto().getId());
        form.setMechanicId(r.getMechanic().getId());
        form.setDate(r.getDate());
        form.setTitle(r.getTitle());
        form.setAbout(r.getAbout());
        form.setPrice(r.getPrice());
        model.addAttribute("repairForm", form);
        model.addAttribute("autos", autoRepository.findAll());
        model.addAttribute("mechanics", mechanicRepository.findAll());
        model.addAttribute("formTitle", "Edit Repair");
        model.addAttribute("formAction", "/repairs/"+id);
        return "repairhistory/form";
    }

    @PostMapping("/{id}")
    public String update(
            @PathVariable Integer id,
            @Valid @ModelAttribute("repairForm") RepairHistoryForm form,
            BindingResult br,
            Model model,
            RedirectAttributes ra) {

        if(br.hasErrors()){
            model.addAttribute("autos", autoRepository.findAll());
            model.addAttribute("mechanics", mechanicRepository.findAll());
            model.addAttribute("formTitle", "Edit Repair");
            model.addAttribute("formAction", "/repairs/"+id);
            return "repairhistory/form";
        }
        RepairHistory r = repairHistoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Repair not found."));
        Auto a = autoRepository.findById(form.getAutoId())
                .orElseThrow(() -> new IllegalArgumentException("Auto not found."));
        Mechanic m = mechanicRepository.findById(form.getMechanicId())
                .orElseThrow(() -> new IllegalArgumentException("Mechanic not found."));
        r.setAuto(a);
        r.setMechanic(m);
        r.setDate(form.getDate());
        r.setTitle(form.getTitle());
        r.setAbout(form.getAbout());
        r.setPrice(form.getPrice());
        repairHistoryRepository.save(r);
        ra.addFlashAttribute("message", "Repair updated.");
        return "redirect:/repairs";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes ra) {
        repairHistoryRepository.deleteById(id);
        ra.addFlashAttribute("message", "Repair deleted.");
        return "redirect:/repairs";
    }
}
