package org.example.workshopdb.repository;

import org.example.workshopdb.entity.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MechanicRepository extends JpaRepository<Mechanic, Integer> {


    Mechanic findByNameLike(String name);

    Mechanic findByPhone(String phone);

}