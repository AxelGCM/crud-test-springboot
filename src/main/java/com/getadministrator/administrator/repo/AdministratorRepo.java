/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getadministrator.administrator.repo;

import com.getadministrator.administrator.model.Administrator;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Axel
 */
public interface AdministratorRepo extends JpaRepository<Administrator, Long>{
    void deleteAdministratorById(Long id);
    Optional<Administrator> findAdministratorByid(Long id);
}
