package org.example.workshopdb.service;

import org.example.workshopdb.dto.ClientRequest;
import org.example.workshopdb.entity.Client;
import org.example.workshopdb.entity.Mechanic;

import java.util.List;

public interface MechanicService {

    List<Mechanic> findAll();

    Mechanic getByID(Integer id);

    Client create(ClientRequest request);

    Client update(ClientRequest request, Integer id);

    Client delete(Integer id);

}
