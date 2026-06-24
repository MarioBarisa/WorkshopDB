package org.example.workshopdb.service.impl;

import org.example.workshopdb.dto.ClientRequest;
import org.example.workshopdb.entity.Client;
import org.example.workshopdb.repository.ClientRepository;
import org.example.workshopdb.service.clientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class clientServiceImpl implements clientService {

    private final ClientRepository clientRepository;

    clientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findByID(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client create(ClientRequest request) {
        Client noviKlijent = new Client();
        noviKlijent.setName(request.getName());
        noviKlijent.setTelnumber(request.getTelnumber());
        noviKlijent.setEmail(request.getEmail());

        return clientRepository.save(noviKlijent);
    }

    @Override
    public Client update(ClientRequest req, Integer id) {
        var provjera = clientRepository.findById(id);
        if (provjera.isPresent()) {
            Client postojeciKlijent = provjera.get();
            postojeciKlijent.setName(req.getName());
            postojeciKlijent.setTelnumber(req.getTelnumber());
            postojeciKlijent.setEmail(req.getEmail());

            return clientRepository.save(postojeciKlijent);
        }
        return null;
    }

    @Override
    public Client delete(Integer id) {
        var provjera = clientRepository.findById(id);
        if (provjera.isPresent()) {
            Client klijent = provjera.get();
            clientRepository.deleteById(id);
            return klijent;
        }
        return null;
    }
}
