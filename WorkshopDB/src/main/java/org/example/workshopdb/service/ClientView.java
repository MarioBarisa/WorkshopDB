package org.example.workshopdb.service;

import jakarta.transaction.Transactional;
import org.example.workshopdb.dto.ClientForm;
import org.example.workshopdb.entity.Client;
import org.example.workshopdb.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ClientView {

    private final ClientRepository clientRepository;


    public ClientView(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public List<Client> search(String query){
        if(query==null || query.isBlank()){
            return  clientRepository.findAll();
        }else {
            return clientRepository.findByNameContainingIgnoreCase(query);
        }
    }

    public Client findByID(Integer id){
       return clientRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Client does not exist."));
    }

    public void save(ClientForm clientForm){
        Client c = new Client();
        c.setName(clientForm.getName());
        c.setTelnumber(clientForm.getTelnumber());
        c.setEmail(clientForm.getEmail());
        clientRepository.save(c);
    }

    public void update(Integer id, ClientForm clientForm){
        Client c = findByID(id);
        c.setName(clientForm.getName());
        c.setTelnumber(clientForm.getTelnumber());
        c.setEmail(clientForm.getEmail());
        clientRepository.save(c);
    }

    public void delete(Integer id){
        clientRepository.deleteById(id);
    }

    public ClientForm toForm(Client c){
        ClientForm f = new ClientForm();
        f.setName(c.getName());
        f.setEmail(c.getEmail());
        f.setTelnumber(c.getTelnumber());
        return f;
    }

}
