package com.diainstalwater.diaInstalWater.controller;

import com.diainstalwater.diaInstalWater.model.Client;
import com.diainstalwater.diaInstalWater.model.Plumber;
import com.diainstalwater.diaInstalWater.model.Work;
import com.diainstalwater.diaInstalWater.service.ClientService;
import com.diainstalwater.diaInstalWater.service.PlumberService;
import com.diainstalwater.diaInstalWater.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    ClientService clientService;
    @Autowired
    WorkService workService;
    @Autowired
    PlumberService plumberService;
    @GetMapping("/clients")
    public String getClients(Model model){
        List<Client> clientList = clientService.findAllClients();
        model.addAttribute("clients", clientList);  // clients intra in client.html unde fac tabelul

        /*List<Work> workList = workService.findAllWorks();
        model.addAttribute("works", workList);

        List<Plumber> plumberList = plumberService.findAllPlumbers();
        model.addAttribute("plumbers", plumberList);*/

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
    @RequestMapping(value = "/clients/findById", method = RequestMethod.GET) // method = RequestMethod.GET este optional, merege si fara
    @ResponseBody
    public Client findById(Long id){
        return clientService.getClientById(id);
    }

   /* @RequestMapping(value = "/clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Client client) {
        clientService.updateClient(client);
        return "redirect:/clients";
    }*/
    // merge si metoda de mai sus, am facut o metoda update in service, merge si prin folosirea metodei create

    @RequestMapping(value = "/clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Client client) {
        clientService.createClient(client);
        return "redirect:/clients";
    }
    @RequestMapping(value = "/clients/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        clientService.delete(id);
        return "redirect:/clients";
    }
}
