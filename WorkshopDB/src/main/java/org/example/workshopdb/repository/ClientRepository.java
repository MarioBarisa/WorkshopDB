package org.example.workshopdb.repository;

import org.example.workshopdb.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {


    Client findByName(String name);

     Client findByID(Integer id);

    Client findByTelnumber(String telnumber);

    List<Client> findByNameLike(String name);

    Client findByEmailLike(String email);


}