package org.example.workshopdb.repository;

import org.example.workshopdb.entity.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoRepository extends JpaRepository<Auto, Integer> {


    List<Auto> findByModelOrMake(String model, String make);


}