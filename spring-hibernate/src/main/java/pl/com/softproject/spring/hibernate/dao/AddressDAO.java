/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.hibernate.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.com.softproject.spring.hibernate.model.Address;

/**
 *
 * @author Adrian Lapierre <adrian@soft-project.pl>
 */
public interface AddressDAO extends CrudRepository<Address, Long>{
    
    public List<Address> findByPersonId(Long id);
    
    @Query("select a from Person p join p.addresses a where p.id = ?")
    public List<Address> findByPersonIdJPQL(Long id);
    
}
