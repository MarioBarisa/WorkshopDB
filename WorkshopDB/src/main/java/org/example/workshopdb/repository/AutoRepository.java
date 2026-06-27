package org.example.workshopdb.repository;

import org.example.workshopdb.entity.Auto;
import org.example.workshopdb.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface AutoRepository extends JpaRepository<Auto, Integer> {


    List<Auto> findByModelOrMake(String model, String make);

    List<Auto> findByClient_NameLikeAndMakeContainsAndModelLike(String name, String make, String model);

    Auto findByVin(@NonNull String vin);

    List<Auto> findByClient_Telnumber(String telnumber);

    List<Auto> findByClient_Name(String name);

    List<Auto> findByClient_Email(String email);

    List<Auto> findByClient_Id(Integer clientId);

    List<Auto> findByMakeContainingIgnoreCaseOrModelContainingIgnoreCase(String make, String model);

    List<Auto> findByClient_NameContainingIgnoreCase(String clientName);


    List<Auto> findAllByMake(String make);
}