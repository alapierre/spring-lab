/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softprojest.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author CSI
 */
@ContextConfiguration("/context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ContextTest {
    
    @Test
    public void test() {
        System.out.println("!!!");
    }
    
}
