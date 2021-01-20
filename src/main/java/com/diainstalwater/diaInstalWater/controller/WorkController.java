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
public class WorkController {
    @Autowired
     WorkService workService;
    @Autowired
     ClientService clientService;
    @Autowired
     PlumberService plumberService;
    @GetMapping("/works")
    public String getWorks(Model model){
        List<Work> workList = workService.findAllWorks();
        model.addAttribute("works", workList);

        List<Client> clientList = clientService.findAllClients();
        model.addAttribute("clients", clientList);

        List<Plumber> plumberList = plumberService.findAllPlumbers();
        model.addAttribute("plumbers", plumberList);

        return "Work";
    }
    @PostMapping("/works/addNew")
    public String addNew(Work work) {
        workService.createWork(work);
        return "redirect:/works";
    }
    @RequestMapping(value = "/works/findById", method = RequestMethod.GET)
    @ResponseBody
    public Work findById(Long id){
        return workService.getWorkById(id);
    }
    @RequestMapping(value = "/works/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Work work) {
        workService.createWork(work);
        return "redirect:/works";
    }
    @RequestMapping(value = "/works/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        workService.deleteWorkById(id);
        return "redirect:/works";
    }

}
