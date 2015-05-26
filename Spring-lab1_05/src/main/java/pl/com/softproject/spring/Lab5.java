package pl.com.softproject.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.com.softproject.spring.model.Entry;
import pl.com.softproject.spring.model.repository.PhoneBookRepository;

public class Lab5 {
	public static void main( String args[] ) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("context.xml");

		PhoneBookRepository repository1 = (PhoneBookRepository) factory.getBean("repository1");
		System.out.println("*************** Repository1 ***************");
		for(Entry entry : repository1.findAllEntries()){
			System.out.println(entry.toString());
		}
		
		PhoneBookRepository repository2 = (PhoneBookRepository) factory.getBean("repository2");
		System.out.println("*************** Repository2 ***************");
		for(Entry entry : repository2.findAllEntries()){
			System.out.println(entry.toString());
		}
		
	}
}
