/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.spring.lab.intro;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Adrian Lapierre <adrian@soft-project.pl>
 */
public class Appliacation {
    
    public static void main(String[] args) {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("newSpringXMLConfig.xml");
        
        C c = ctx.getBean(C.class);
        c.doStuff();
    }
    
}
