/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.com.softproject.spring.lab1_08.model.Client;

/**
 *
 * @author S108_1
 */
public interface ClientDAO extends CrudRepository<Client, Long>{
    
    public List<Client> findByLastName(String lastName);
    
    @Query("select c from Client c where c.lastName LIKE :lastName")
    public List<Client> findByJPQL(@Param("lastName") String lastName); 
}
