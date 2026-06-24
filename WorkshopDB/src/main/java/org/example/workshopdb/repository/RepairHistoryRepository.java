package org.example.workshopdb.repository;

import org.example.workshopdb.entity.RepairHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepairHistoryRepository extends JpaRepository<RepairHistory, Integer> {


    List<RepairHistory> findByAuto_Id(Integer id);

    List<RepairHistory> findByAuto_Client_Id(Integer id);

}