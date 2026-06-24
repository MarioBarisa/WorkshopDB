package org.example.workshopdb.service.impl;

import org.example.workshopdb.dto.AutoRequest;
import org.example.workshopdb.entity.Auto;
import org.example.workshopdb.repository.AutoRepository;
import org.example.workshopdb.repository.ClientRepository;
import org.example.workshopdb.service.auto;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class autoService implements auto {

    private final AutoRepository autoRepository;
    private final ClientRepository clientRepository;

    autoService(AutoRepository autoRepository, ClientRepository clientRepository) {
        this.autoRepository = autoRepository;
        this.clientRepository = clientRepository;
    }


    @Override
    public List<Auto> findAll() {
        return autoRepository.findAll();
    }

    @Override
    public Optional<Auto> findById(Integer id) {
        return autoRepository.findById(id);
    }

    @Override
    public Auto create(@NonNull AutoRequest req) {
        Auto noviAuto = new Auto();
        noviAuto.setMake(req.getMake());
        noviAuto.setModel(req.getModel());
        noviAuto.setKW(req.getKW());
        noviAuto.setClient(clientRepository.findById(req.getClientID()).orElse(null));
        noviAuto.setMileage((req.getMileage()));
        noviAuto.setYear(req.getYear());
        noviAuto.setVin(req.getVin());
        noviAuto.setEnginetype(req.getEnginetype());
        noviAuto.setEngine(req.getEngine());

        return autoRepository.save(noviAuto);
    }

    @Override
    public Auto update(AutoRequest req, Integer id) {
        Optional<Auto> provjera = autoRepository.findById(id);
        if(provjera.isPresent()){
            Auto postojeciAuto = provjera.get();
            postojeciAuto.setMake(req.getMake());
            postojeciAuto.setModel(req.getModel());
            postojeciAuto.setKW(req.getKW());
            postojeciAuto.setClient(clientRepository.findById(req.getClientID()).orElse(null));
            postojeciAuto.setMileage(req.getMileage());
            postojeciAuto.setYear(req.getYear());
            postojeciAuto.setVin(req.getVin());
            postojeciAuto.setEnginetype(req.getEnginetype());
            postojeciAuto.setEngine(req.getEngine());

            return autoRepository.save(postojeciAuto);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        autoRepository.deleteById(id);
    }
}
