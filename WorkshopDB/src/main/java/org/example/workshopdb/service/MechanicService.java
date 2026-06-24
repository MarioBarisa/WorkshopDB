package org.example.workshopdb.service;

import org.example.workshopdb.dto.MechanicRequest;
import org.example.workshopdb.entity.Mechanic;

import java.util.List;

public interface MechanicService {

    List<Mechanic> findAll();

    Mechanic getByID(Integer id);

    Mechanic create(MechanicRequest request);

    Mechanic update(MechanicRequest request, Integer id);

    void delete(Integer id);

}
