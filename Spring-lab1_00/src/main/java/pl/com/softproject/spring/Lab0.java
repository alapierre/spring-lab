package pl.com.softproject.spring;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.com.softproject.spring.model.Address;
import pl.com.softproject.spring.model.Person;

public class Lab0 {

    public static void main(String args[]) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");

        Person p = ctx.getBean(Person.class);
        
        System.out.println(p);
        
        System.out.println(ToStringBuilder.reflectionToString( p ));
        
        Address add = ctx.getBean(Address.class);
               
        System.out.println(add);
        
    }

}
