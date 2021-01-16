package com.diainstalwater.diaInstalWater.controller;

import com.diainstalwater.diaInstalWater.model.Work;
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
    @GetMapping("/works")
    public String getWorks(Model model){
        List<Work> workList = workService.findAllWorks();
        model.addAttribute("works", workList);
        return "Work";
    }
    @PostMapping("/works/addNew")
    public String addNew(Work work) {
        workService.createWork(work);
        return "redirect:/works";
    }

}
