/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getadministrator.administrator;

import com.getadministrator.administrator.model.Administrator;
import com.getadministrator.administrator.service.AdministratorService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Axel
 */
@RestController
@RequestMapping("/administrator")
public class AdministratorResource {
    private final AdministratorService adminsitratorService;

    public AdministratorResource(AdministratorService adminsitratorService) {
        this.adminsitratorService = adminsitratorService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Administrator>> getAllAdministrator(){
        List<Administrator> administrators = adminsitratorService.findAllAdministrators();
        return new ResponseEntity<>(administrators, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Administrator> getAdministratorById(@PathVariable("id") Long id) throws Throwable{
        Administrator administrator = adminsitratorService.findAdministratorById(id);
        return new ResponseEntity<>(administrator, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Administrator> addAdministrator(@RequestBody Administrator administrator){
        Administrator newAdministrator = adminsitratorService.addAdministrator(administrator);
        return new ResponseEntity<>(newAdministrator,HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Administrator> updateAdministrator(@RequestBody Administrator administrator){
        Administrator updateAdministrator = adminsitratorService.updateAdministrator(administrator);
        return new ResponseEntity<>(updateAdministrator,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAdministrator(@PathVariable("id") Long id){
        adminsitratorService.deleteAdministrator(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
}
