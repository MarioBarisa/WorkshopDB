package org.example.workshopdb.service.impl;

import org.example.workshopdb.dto.MechanicRequest;
import org.example.workshopdb.entity.Mechanic;
import org.example.workshopdb.repository.MechanicRepository;
import org.example.workshopdb.service.MechanicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class mechanicServiceImpl implements MechanicService {

    private final MechanicRepository mechanicRepository;

    mechanicServiceImpl(MechanicRepository mechanicRepository) {
        this.mechanicRepository = mechanicRepository;
    }

    @Override
    public List<Mechanic> findAll() {
        return mechanicRepository.findAll();
    }

    @Override
    public Mechanic getByID(Integer id) {
        return mechanicRepository.findById(id).orElse(null);
    }

    @Override
    public Mechanic create(MechanicRequest request) {
        Mechanic noviMehanicar = new Mechanic();
        noviMehanicar.setName(request.getName());
        noviMehanicar.setPhone(request.getPhone());

        return mechanicRepository.save(noviMehanicar);
    }

    @Override
    public Mechanic update(MechanicRequest request, Integer id) {
        var provjera = mechanicRepository.findById(id);
        if (provjera.isPresent()) {
            Mechanic postojeciMehanicar = provjera.get();
            postojeciMehanicar.setName(request.getName());
            postojeciMehanicar.setPhone(request.getPhone());

            return mechanicRepository.save(postojeciMehanicar);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        mechanicRepository.deleteById(id);
    }
}
