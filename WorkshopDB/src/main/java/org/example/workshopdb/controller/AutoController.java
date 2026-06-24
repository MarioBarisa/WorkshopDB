package org.example.workshopdb.controller;

import org.example.workshopdb.dto.AutoRequest;
import org.example.workshopdb.entity.Auto;
import org.example.workshopdb.service.auto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auto")
class AutoController {

    private final auto autoService;

    AutoController(auto autoService) {
        this.autoService = autoService;
    }

    @GetMapping
    List<Auto> findAll() {
        return autoService.findAll();
    }

    @GetMapping("/{id}")
    Optional<Auto> findById(@PathVariable Integer id) {
        return autoService.findById(id);
    }

    @PostMapping
    Auto create(@RequestBody AutoRequest request) {
        return autoService.create(request);
    }

    @PutMapping("/{id}")
    Auto update(@RequestBody AutoRequest request, @PathVariable Integer id) {
        return autoService.update(request, id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        autoService.delete(id);
    }
}
