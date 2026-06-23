package org.example.workshopdb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "RepairHistory", schema = "WorkshopDB", indexes = {
        @Index(name = "auto_id",
                columnList = "auto_id"),
        @Index(name = "mechanic_id",
                columnList = "mechanic_id")})
public class RepairHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "repair_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "auto_id", nullable = false)
    private Auto auto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mechanic_id", nullable = false)
    private Mechanic mechanic;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "title", length = 100)
    private String title;

    @Lob
    @Column(name = "about")
    private String about;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;


}