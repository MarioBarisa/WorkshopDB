package org.example.workshopdb.service;

import org.example.workshopdb.dto.AutoRequest;
import org.example.workshopdb.entity.Auto;

import java.util.List;
import java.util.Optional;


public interface auto {

    List<Auto> findAll();

    Optional<Auto> findById(Integer id);

    Auto create(AutoRequest req);

    Auto update(AutoRequest request, Integer id);

    void delete(Integer id);

}
