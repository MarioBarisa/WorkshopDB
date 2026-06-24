package org.example.workshopdb.controller;

import org.example.workshopdb.dto.MechanicRequest;
import org.example.workshopdb.entity.Mechanic;
import org.example.workshopdb.service.MechanicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mechanic")
class MechanicController {

    private final MechanicService mechanicService;

    MechanicController(MechanicService mechanicService) {
        this.mechanicService = mechanicService;
    }

    @GetMapping
    List<Mechanic> findAll() {
        return mechanicService.findAll();
    }

    @GetMapping("/{id}")
    Mechanic getByID(@PathVariable Integer id) {
        return mechanicService.getByID(id);
    }

    @PostMapping
    Mechanic create(@RequestBody MechanicRequest request) {
        return mechanicService.create(request);
    }

    @PutMapping("/{id}")
    Mechanic update(@RequestBody MechanicRequest request, @PathVariable Integer id) {
        return mechanicService.update(request, id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        mechanicService.delete(id);
    }
}
