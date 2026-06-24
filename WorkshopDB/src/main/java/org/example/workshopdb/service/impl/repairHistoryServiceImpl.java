package org.example.workshopdb.service.impl;

import org.example.workshopdb.dto.RepairHistoryRequest;
import org.example.workshopdb.entity.Auto;
import org.example.workshopdb.entity.Mechanic;
import org.example.workshopdb.entity.RepairHistory;
import org.example.workshopdb.repository.AutoRepository;
import org.example.workshopdb.repository.MechanicRepository;
import org.example.workshopdb.repository.RepairHistoryRepository;
import org.example.workshopdb.service.RepairHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class repairHistoryServiceImpl implements RepairHistoryService {

    private final RepairHistoryRepository repairHistoryRepository;
    private final AutoRepository autoRepository;
    private final MechanicRepository mechanicRepository;

    repairHistoryServiceImpl(RepairHistoryRepository repairHistoryRepository, AutoRepository autoRepository, MechanicRepository mechanicRepository) {
        this.repairHistoryRepository = repairHistoryRepository;
        this.autoRepository = autoRepository;
        this.mechanicRepository = mechanicRepository;
    }

    @Override
    public List<RepairHistory> findAll() {
        return repairHistoryRepository.findAll();
    }

    @Override
    public RepairHistory findByID(Integer id) {
        return repairHistoryRepository.findById(id).orElse(null);
    }

    @Override
    public RepairHistory create(RepairHistoryRequest request) {
        Auto auto = autoRepository.findById(request.getAutoID()).orElse(null);
        Mechanic mechanic = mechanicRepository.findById(request.getMechanicID()).orElse(null);

        if (auto == null || mechanic == null) {
            return null;
        }

        RepairHistory noviPopravak = new RepairHistory();
        noviPopravak.setAuto(auto);
        noviPopravak.setMechanic(mechanic);
        noviPopravak.setDate(request.getDate());
        noviPopravak.setTitle(request.getTitle());
        noviPopravak.setAbout(request.getAbout());
        noviPopravak.setPrice(request.getPrice());

        return repairHistoryRepository.save(noviPopravak);
    }

    @Override
    public RepairHistory update(RepairHistoryRequest request, Integer id) {
        var provjera = repairHistoryRepository.findById(id);
        if (provjera.isPresent()) {
            Auto auto = autoRepository.findById(request.getAutoID()).orElse(null);
            Mechanic mechanic = mechanicRepository.findById(request.getMechanicID()).orElse(null);

            if (auto == null || mechanic == null) {
                return null;
            }

            RepairHistory postojeciPopravak = provjera.get();
            postojeciPopravak.setAuto(auto);
            postojeciPopravak.setMechanic(mechanic);
            postojeciPopravak.setDate(request.getDate());
            postojeciPopravak.setTitle(request.getTitle());
            postojeciPopravak.setAbout(request.getAbout());
            postojeciPopravak.setPrice(request.getPrice());

            return repairHistoryRepository.save(postojeciPopravak);
        }
        return null;
    }

    @Override
    public RepairHistory delete(Integer id) {
        var provjera = repairHistoryRepository.findById(id);
        if (provjera.isPresent()) {
            RepairHistory popravak = provjera.get();
            repairHistoryRepository.deleteById(id);
            return popravak;
        }
        return null;
    }
}
