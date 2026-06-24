package org.example.workshopdb.controller;

import org.example.workshopdb.dto.ClientRequest;
import org.example.workshopdb.entity.Client;
import org.example.workshopdb.service.clientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
class ClientController {

    private final clientService clientService;

    ClientController(clientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    Client findByID(@PathVariable Integer id) {
        return clientService.findByID(id);
    }

    @PostMapping
    Client create(@RequestBody ClientRequest request) {
        return clientService.create(request);
    }

    @PutMapping("/{id}")
    Client update(@RequestBody ClientRequest request, @PathVariable Integer id) {
        return clientService.update(request, id);
    }

    @DeleteMapping("/{id}")
    Client delete(@PathVariable Integer id) {
        return clientService.delete(id);
    }
}
