package pl.com.softproject.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.com.softproject.spring.components.ui.AddressBookWindowBuilder;

import java.awt.*;

import javax.swing.*;

public class Lab6 {
	public static void main( String args[] ) {
		ApplicationContext ctx
			= new ClassPathXmlApplicationContext( "config.xml" );
		
		AddressBookWindowBuilder builder
			= (AddressBookWindowBuilder) ctx.getBean( "builder" );
		
		JFrame mainWindow = builder.buildApplicationGUI();
		mainWindow.setSize( new Dimension( 400, 100 ) );
		mainWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		mainWindow.setVisible( true );

	}
}

