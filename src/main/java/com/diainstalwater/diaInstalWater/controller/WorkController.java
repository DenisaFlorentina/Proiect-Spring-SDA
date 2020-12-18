package com.diainstalwater.diaInstalWater.controller;

import com.diainstalwater.diaInstalWater.model.Work;
import com.diainstalwater.diaInstalWater.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/works")
public class WorkController {
    @Autowired
    WorkService workService;
    //create
    @PostMapping
    public Work addWork (@RequestBody Work work){
        return workService.createWork(work);
    }
    //get
    @RequestMapping(method = RequestMethod.GET)
    public List<Work> findAllWorks(){
        return workService.findAllWorks();
    }
    //get endpoint
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Work findWorkById(@PathVariable Long id){
        return workService.getWorkById(id);
    }
    //delete
   /* @DeleteMapping
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteWorkById(Long id){
        workService.deleteWorkById(id);
    }*/

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        workService.deleteWorkById(id);
    }

}
