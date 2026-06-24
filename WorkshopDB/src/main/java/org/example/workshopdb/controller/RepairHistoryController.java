package org.example.workshopdb.controller;

import org.example.workshopdb.dto.RepairHistoryRequest;
import org.example.workshopdb.entity.RepairHistory;
import org.example.workshopdb.service.RepairHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repairhistory")
class RepairHistoryController {

    private final RepairHistoryService repairHistoryService;

    RepairHistoryController(RepairHistoryService repairHistoryService) {
        this.repairHistoryService = repairHistoryService;
    }

    @GetMapping
    List<RepairHistory> findAll() {
        return repairHistoryService.findAll();
    }

    @GetMapping("/{id}")
    RepairHistory findByID(@PathVariable Integer id) {
        return repairHistoryService.findByID(id);
    }

    @PostMapping
    RepairHistory create(@RequestBody RepairHistoryRequest request) {
        return repairHistoryService.create(request);
    }

    @PutMapping("/{id}")
    RepairHistory update(@RequestBody RepairHistoryRequest request, @PathVariable Integer id) {
        return repairHistoryService.update(request, id);
    }

    @DeleteMapping("/{id}")
    RepairHistory delete(@PathVariable Integer id) {
        return repairHistoryService.delete(id);
    }
}
