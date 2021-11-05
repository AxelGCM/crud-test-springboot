/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getadministrator.administrator.service;

import com.getadministrator.administrator.exception.UserNotFoundException;
import com.getadministrator.administrator.model.Administrator;
import com.getadministrator.administrator.repo.AdministratorRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Axel
 */
public class AdministratorService {
    private final AdministratorRepo administratorRepo;

    @Autowired
    public AdministratorService(AdministratorRepo administratorRepo) {
        this.administratorRepo = administratorRepo;
    }
    
    public Administrator addAdministrator(Administrator administrator){
        return administratorRepo.save(administrator);
    }
    
    public List<Administrator> findAllAdministrators(){
        return administratorRepo.findAll();
    }
    
    public Administrator updateAdministrator(Administrator administrator){
        return administratorRepo.save(administrator);
    }
    
    public Administrator findAdministratorById(Long id) throws Throwable{
        return (Administrator) administratorRepo.findAdministratorByid(id)
                .orElseThrow(() -> new UserNotFoundException("Administrator by id " + id + " was not found"));
    }
    
    public void deleteAdministrator(Long id){
        administratorRepo.deleteAdministratorById(id);
    }
}
