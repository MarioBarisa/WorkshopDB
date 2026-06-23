package org.example.workshopdb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Client", schema = "WorkshopDB", uniqueConstraints = {@UniqueConstraint(name = "email",
        columnNames = {"email"})})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "telnumber", length = 20)
    private String telnumber;

    @Column(name = "email", length = 100)
    private String email;


}