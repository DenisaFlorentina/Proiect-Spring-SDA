package com.diainstalwater.diaInstalWater.controller;

import com.diainstalwater.diaInstalWater.model.Plumber;
import com.diainstalwater.diaInstalWater.service.PlumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plumbers")
public class PlumberController {
    @Autowired
    PlumberService plumberService;
    //create
    @PostMapping
    public Plumber addPlumber (@RequestBody Plumber plumber){
        return plumberService.createPlumber(plumber);
    }
    //get
    @RequestMapping(method = RequestMethod.GET)
    public List<Plumber> findAllPlumbers(){
        return plumberService.findAllPlumbers();
    }
    //get endpoint
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Plumber findPlumberById(@PathVariable Long id){
        return plumberService.getPlumberById(id);
    }
    //update
    @PutMapping("{id}")
    public void updateById(
            @PathVariable("id") Long id,
            @RequestBody Plumber plumber){
            plumberService.updatePlumberById(id, plumber);
        }
    //delete
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        plumberService.deletePlumberById(id);
    }
}
