/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import pl.com.softproject.spring.jdbc.model.Person;

/**
 *
 * @author CSI
 */
@Repository
public class PersonDAOJdbcImpl implements PersonDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private SimpleJdbcInsert simpleJdbcInsert;
    
    @Override
    public void update(Person person) {
        String SQL = "UPDATE  person set name = ?, last_name = ? where id = ?";
        jdbcTemplate.update(SQL, person.getName(), person.getLastName(), person.getId());
    } 
    
    @Override
    public long save(Person person) {
        Number id = simpleJdbcInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(person));
        return id.longValue();
    }
    
    @Override
    public Person loadById(long id) {
        
        String sql = "select * from person where id = ?";
        
        return loadByIdWithReflection(sql, id);
    }

    protected Person loadByIdWithoutReflection(String sql, long id) throws DataAccessException {
        return jdbcTemplate.queryForObject(sql, new ParsonRowMapperImpl(), id);
    }
    
    protected Person loadByIdWithReflection(String sql, long id) {
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Person.class), id);
    }
    
    @Override
    public List<Person> loadAll() {
        String sql = "select * from person";
        return jdbcTemplate.query(sql, new ParsonRowMapperImpl());
    }

    private static class ParsonRowMapperImpl implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int i) throws SQLException {
            
            Person p = new Person();
            
            p.setId(rs.getLong("id"));
            p.setName(rs.getString("name"));
            p.setLastName(rs.getString("last_name"));
            
            return p;
        }
    }
    
}
