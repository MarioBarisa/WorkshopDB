package org.example.workshopdb.service;

import org.example.workshopdb.dto.RepairHistoryRequest;
import org.example.workshopdb.entity.RepairHistory;

import java.util.List;

public interface RepairHistoryService {

    List<RepairHistory> findAll();

    RepairHistory findByID(Integer id);

    RepairHistory create (RepairHistoryRequest request);

    RepairHistory update (RepairHistoryRequest request, Integer id);

    RepairHistory delete (Integer id);

}
