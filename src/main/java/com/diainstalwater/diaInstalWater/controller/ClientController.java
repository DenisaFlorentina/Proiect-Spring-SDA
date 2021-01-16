package com.diainstalwater.diaInstalWater.controller;

import com.diainstalwater.diaInstalWater.model.Client;
import com.diainstalwater.diaInstalWater.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    ClientService clientService;
    @GetMapping("/clients")
    public String getClients(Model model){
        List<Client> clientList = clientService.findAllClients();
        model.addAttribute("clients", clientList);  // clients intra in client.html unde fac tabelul
        return "Client"; // rep html-ul
    }
    @PostMapping("/clients/addNew")
    public String addNew(Client client) {
        clientService.createClient(client);
        return "redirect:/clients";
    }
    /*@RequestMapping("/clients/findById")
    @ResponseBody
    public Client findById(Long id){
        return clientService.getClientById(id);
    }*/    // si metoda asta merge, e metoda lui k
    @RequestMapping(value = "/clients/findById", method = RequestMethod.GET)
    @ResponseBody
    public Client findById(Long id){
        return clientService.getClientById(id);
    }

    @RequestMapping(value = "/clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Client client) {
        clientService.updateClient(client);
        return "redirect:/clients";
    }
}
