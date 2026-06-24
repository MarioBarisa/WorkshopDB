package org.example.workshopdb.service;

import org.example.workshopdb.dto.ClientRequest;
import org.example.workshopdb.entity.Client;

import java.util.List;

public interface clientService {

    List<Client> findAll();

    Client findByID( Integer id);

    Client create(ClientRequest request);

    Client update(ClientRequest req, Integer id);

    Client delete(Integer id);

}
