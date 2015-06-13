/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import pl.com.softproject.spring.lab1_08.model.Seller;

/**
 *
 * @author S108_8
 */
public interface SellerDAO extends CrudRepository<Seller, String>{
    
    public List<Seller> findByUserLoginIgnoreCaseLike(String login);
    public List<Seller> findByEmail(String email);
    public List<Seller> findByNumberPhone(String numberPhone);
    
}