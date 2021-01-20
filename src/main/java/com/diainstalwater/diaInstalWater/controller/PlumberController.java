package com.diainstalwater.diaInstalWater.controller;

import com.diainstalwater.diaInstalWater.model.Client;
import com.diainstalwater.diaInstalWater.model.Plumber;
import com.diainstalwater.diaInstalWater.service.PlumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PlumberController {
    @Autowired
    PlumberService plumberService;
    @GetMapping("/plumbers")
    public String getPlumbers(Model model){
        List<Plumber> plumberList = plumberService.findAllPlumbers();
        model.addAttribute("plumbers",  plumberList);
        return "Plumber";
    }

    @PostMapping("/plumbers/addNew")
    public String addNew(Plumber plumber) {
        plumberService.createPlumber(plumber);
        return "redirect:/plumbers";
    }
    @RequestMapping(value = "/plumbers/findById", method = RequestMethod.GET)
    @ResponseBody
    public Plumber findById(Long id){
        return plumberService.getPlumberById(id);
    }

    @RequestMapping(value = "/plumbers/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Plumber plumber) {
        plumberService.createPlumber(plumber);
        return "redirect:/plumbers";
    }
    @RequestMapping(value = "/plumbers/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        plumberService.deletePlumberById(id);
        return "redirect:/plumbers";
    }

}
