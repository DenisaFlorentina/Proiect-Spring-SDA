package com.diainstalwater.diaInstalWater.service;

import com.diainstalwater.diaInstalWater.model.Client;
import com.diainstalwater.diaInstalWater.model.Plumber;
import com.diainstalwater.diaInstalWater.repository.ClientRepository;
import com.diainstalwater.diaInstalWater.repository.PlumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlumberService {
    @Autowired
    PlumberRepository plumberRepository;
    //create
    public Plumber createPlumber(Plumber newPlumber){
        return plumberRepository.saveAndFlush(newPlumber);
    }
    //findAllPlumbers
    public List<Plumber> findAllPlumbers(){
        return plumberRepository.findAll();
    }
    //findPlumberById
    public Plumber getPlumberById(Long id){
        return plumberRepository.findById(id).get();
    }

    //updatePlumber

    //deletePlumber
    public void deletePlumberById(Long id){
        plumberRepository.deleteById(id);
    }
}