package pl.com.softproject.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import pl.com.softproject.spring.model.Address;
import pl.com.softproject.spring.model.Person;

public class Lab1 {
	public static void main( String args[] ) {
		Resource resource = new ClassPathResource( "context.xml" );
		BeanFactory factory = new XmlBeanFactory( resource );
		Person person = (Person) factory.getBean("person");
		Address address = (Address) factory.getBean("address");
		System.out.println(person.toString());
		System.out.println(address.toString());
	}
}
