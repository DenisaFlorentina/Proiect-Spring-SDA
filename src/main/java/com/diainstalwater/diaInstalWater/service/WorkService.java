package com.diainstalwater.diaInstalWater.service;

import com.diainstalwater.diaInstalWater.model.Work;
import com.diainstalwater.diaInstalWater.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkService {
    @Autowired
    WorkRepository workRepository;
    //create
    public Work createWork (Work newWork){
        return workRepository.saveAndFlush(newWork);
    }
    //findAllWorks
    public List<Work> findAllWorks(){
        return workRepository.findAll();
    }
    //findWorkById
    public  Work getWorkById(Long id){
        return workRepository.findById(id).get();
    }
    //updateWork
    public void updateWorkById(Long id, Work work){
        for (Work s: workRepository.findAll() ){
            if(id.equals(s.getWorkid())){
                s.setWorkname(work.getWorkname());
            }
            workRepository.save(s);
        }
    }

    //deleteWork
    public void deleteWorkById(Long id){
        workRepository.deleteById(id);
    }
}
