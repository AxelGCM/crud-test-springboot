/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getadministrator.administrator.service;

import com.getadministrator.administrator.model.Administrator;
import com.getadministrator.administrator.repo.AdministratorRepo;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

/**
 *
 * @author Axel
 */
public class AdministratorService {
    private final AdministratorRepo administratorRepo;

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
    
    public Administrator findAdministratorById(Long id){
        return (Administrator) administratorRepo.findAdministratorByid(id)
                .orElseThrow(() -> new UserPrincipalNotFoundException("Administrator by id " + id + " was not found"));
    }
    
    public void deleteAdministrator(Long id){
        administratorRepo.deleteAdministratorById(id);
    }
}
