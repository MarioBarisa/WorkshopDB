package org.example.workshopdb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Auto", schema = "WorkshopDB", indexes = {@Index(name = "client_id",
        columnList = "client_id")}, uniqueConstraints = {@UniqueConstraint(name = "VIN",
        columnNames = {"VIN"})})
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auto_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "make", length = 50)
    private String make;

    @Column(name = "model", length = 50)
    private String model;

    @Column(name = "VIN", length = 17)
    private String vin;

    @Lob
    @Column(name = "enginetype")
    private String enginetype;

    @Column(name = "engine", length = 30)
    private String engine;

    @Column(name = "kW")
    private Integer kW;

    @Column(name = "year")
    private Integer year;

    @Column(name = "mileage")
    private Integer mileage;


}