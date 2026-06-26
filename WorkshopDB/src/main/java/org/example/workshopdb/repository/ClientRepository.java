package org.example.workshopdb.repository;

import org.example.workshopdb.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {


    Client findByName(String name);

    Client findByTelnumber(String telnumber);

    List<Client> findByNameLike(String name);

    Client findByEmailLike(String email);

    List<Client> findByNameContainingIgnoreCase(String name);

    Optional<Client> findByEmail(String email);


}