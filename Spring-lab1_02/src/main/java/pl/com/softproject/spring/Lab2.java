package pl.com.softproject.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.com.softproject.spring.model.Address;
import pl.com.softproject.spring.model.Entry;
import pl.com.softproject.spring.model.Person;
import pl.com.softproject.spring.model.Phone;

public class Lab2 {

    public static void main(String args[]) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("context.xml");

        Entry entry = (Entry) factory.getBean("entry");
        System.out.println(entry.toString());

        Person person = entry.getPerson();
        System.out.println(person.toString());

        Address address = entry.getAddress();
        System.out.println(address.toString());

        Phone phone = entry.getPhone();
        System.out.println(phone.toString());
    }
}
