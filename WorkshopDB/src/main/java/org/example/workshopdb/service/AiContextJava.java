package org.example.workshopdb.service;

import org.example.workshopdb.entity.Auto;
import org.example.workshopdb.entity.Client;
import org.example.workshopdb.entity.Mechanic;
import org.example.workshopdb.entity.RepairHistory;
import org.example.workshopdb.repository.AutoRepository;
import org.example.workshopdb.repository.ClientRepository;
import org.example.workshopdb.repository.MechanicRepository;
import org.example.workshopdb.repository.RepairHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AiContextJava {

    private final AutoRepository autoRepository;
    private final ClientRepository clientRepository;
    private final RepairHistoryRepository repairHistoryRepository;
    private final MechanicRepository mechanicRepository;


    public AiContextJava(AutoRepository autoRepository, ClientRepository clientRepository, RepairHistoryRepository repairHistoryRepository, MechanicRepository mechanicRepository) {
        this.autoRepository = autoRepository;
        this.clientRepository = clientRepository;
        this.repairHistoryRepository = repairHistoryRepository;
        this.mechanicRepository = mechanicRepository;
    }

    public String buildContext(boolean autos, boolean mech, boolean repairs, boolean clients){
        StringBuilder stringBuilder = new StringBuilder();

        if(clients){
            List<Client> list = clientRepository.findAll();
            stringBuilder.append("--- KLIJENTI IZ KORISNIKOVE BAZE ---\n");
            list.forEach(customer -> stringBuilder.append(
                    String.format("ID:%d | Ime:%s | Tel:%s | Email:%s\n",
                            customer.getId(), customer.getName(), customer.getTelnumber(), customer.getEmail())
            ));
        }
        if(autos){
            List<Auto> list = autoRepository.findAll();
            stringBuilder.append("--- AUTOMOBILI IZ KORISNIKOVE BAZE ---\n");
            list.forEach(auto -> stringBuilder.append(
                    String.format("ID:%d | %s %s (%d) | VIN:%s | Motor:%s %s | %dkW | km:%d | KlijentID:%d\n",
                            auto.getId(), auto.getModel(), auto.getMake(), auto.getYear(), auto.getVin(), auto.getEnginetype(), auto.getEngine(),
                            auto.getPowerKW() !=null ? auto.getPowerKW():0, auto.getMileage() != null ? auto.getMileage() : 0, auto.getClient().getId())
            ));
        }
        if(mech){
            List<Mechanic> list = mechanicRepository.findAll();
            stringBuilder.append("--- MEHANICARI UNUTAR ORISNIKOVE BAZE ---\n");
            list.forEach(mechanic -> stringBuilder.append(
                    String.format("ID:%d | Ime:%s | Tel:%s\n",
                            mechanic.getId(), mechanic.getName(), mechanic.getPhone())
            ));
        }
        if (repairs) {
            List<RepairHistory> list = repairHistoryRepository.findAll();
            stringBuilder.append("--- POVIJEST POPRAVAKA UNUTAR KORISNIKOVE BAZE ---\n");
            list.forEach(r -> stringBuilder.append(String.format(
                "ID:%d | AutoID:%d | MehaničarID:%d | MehaničarIme:%s  | Datum:%s | Naslov:%s | Cijena:%s€\n",
                r.getId(), r.getAuto().getId(), r.getMechanic().getId(), r.getMechanic().getName(),
                r.getDate(), r.getTitle(),
                r.getPrice() != null ? r.getPrice().toString() : "N/A"
            )));
        }

        if(!stringBuilder.isEmpty()){
            return stringBuilder.toString();
        }
        return "No data source was chosen.";
    }
}
