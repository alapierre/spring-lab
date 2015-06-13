/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import pl.com.softproject.spring.lab1_08.model.Category;

/**
 *
 * @author Adrian Lapierre <adrian@soft-project.pl>
 */
public interface CategoryDAO extends CrudRepository<Category, String>{
    
    public Category findById(Long id);
    
    public List<Category> findByParentId(Long id);
    
    public List<Category> findByNameIgnoreCaseLike(String name);
}
