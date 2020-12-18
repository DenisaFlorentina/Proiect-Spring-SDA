package com.diainstalwater.diaInstalWater.service;

import com.diainstalwater.diaInstalWater.model.Client;
import com.diainstalwater.diaInstalWater.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    //create
    public Client createClient(Client newClient){
        return clientRepository.saveAndFlush(newClient);
    }
    //findAllClients
    public List<Client> findAllClients(){
        return clientRepository.findAll();
    }
    //findClientById
    public Client getClientById(Long id){
        return clientRepository.findById(id).get();
    }
    //updateClient

    //deleteClient
    public void deleteClientById(Long id){
        clientRepository.deleteById(id);
    }
}
