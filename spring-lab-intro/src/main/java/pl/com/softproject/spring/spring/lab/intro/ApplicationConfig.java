/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.spring.lab.intro;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Adrian Lapierre <adrian@soft-project.pl>
 */
@Configuration
public class ApplicationConfig {
    
    @Bean
    public Interface a() {
        return new A();
    }
    
    @Bean
    @Scope("prototype")
    public Interface b() {
        return new B();
    }
    
    @Bean
    public C c() {
        return new C(a());
    }
    
    public static void main(String[] args) {
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        C c = ctx.getBean(C.class);
        c.doStuff();
    }
    
}
