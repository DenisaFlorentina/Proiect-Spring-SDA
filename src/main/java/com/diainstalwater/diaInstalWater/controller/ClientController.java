package com.diainstalwater.diaInstalWater.controller;

import com.diainstalwater.diaInstalWater.model.Client;
import com.diainstalwater.diaInstalWater.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientService clientService;
    //create
    @PostMapping
    public Client addClient (@RequestBody Client client){
        return clientService.createClient(client);
    }
    //get
    @RequestMapping(method = RequestMethod.GET)
    public List<Client> findAllClients(){
        return clientService.findAllClients();
    }
    //get endpoint
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Client findClientById(@PathVariable Long id){
        return clientService.getClientById(id);
    }
    //update
    @PutMapping("{id}")
    public void updateById(
            @PathVariable("id") Long id,
            @RequestBody Client client){
        clientService.updateClientById(id, client);
    }
    //delete
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        clientService.deleteClientById(id);
    }
}
