package pl.com.softproject.spring.components.ui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import pl.com.softproject.spring.components.LocalizableJButton;
import pl.com.softproject.spring.components.LocalizableJFrame;
import pl.com.softproject.spring.components.LocalizableJLabel;

public class AddressBookWindowBuilder implements ApplicationContextAware {

	private ApplicationContext ctx;
	
	public JFrame buildApplicationGUI() {
		ComponentMediator mediator = new ComponentMediator( ctx );
		
		LocalizableJFrame mainWindow = buildMainFrame( mediator );
		addNameLabel( mediator, mainWindow );
		addNameTextField( mainWindow );
		addAddressLabel( mediator, mainWindow );
		addAddressTextField( mainWindow );
		addSubmitButton( mediator, mainWindow );
		addLocalizingButton( mediator, mainWindow );
		mediator.doLocalization();
		
		return mainWindow;
	}

	private void addLocalizingButton( ComponentMediator mediator,
			LocalizableJFrame mainWindow ) {
		LocalizableJButton localizingButton
			= new LocalizableJButton( "localizing.button" );
		mediator.addLocalizableCompontent( localizingButton );
		mediator.addLocalizingButton( localizingButton );
		mainWindow.add( localizingButton );
	}

	private void addSubmitButton( ComponentMediator mediator,
			LocalizableJFrame mainWindow ) {
		LocalizableJButton submitButton = buildSubmitButton();
		mediator.addLocalizableCompontent( submitButton );
		mainWindow.add( submitButton );
	}

	private void addAddressTextField( LocalizableJFrame mainWindow ) {
		JTextField addressTextField = buildAddressTextField();
		mainWindow.add( addressTextField );
	}

	private void addAddressLabel( ComponentMediator mediator,
			LocalizableJFrame mainWindow ) {
		LocalizableJLabel addressLabel = buildAddressLabel();
		mediator.addLocalizableCompontent( addressLabel );
		mainWindow.add( addressLabel );
	}

	private void addNameTextField( LocalizableJFrame mainWindow ) {
		JTextField nameTextField = buildNameTextField();
		mainWindow.add( nameTextField );
	}

	private void addNameLabel( ComponentMediator mediator,
			LocalizableJFrame mainWindow ) {
		
		LocalizableJLabel nameLabel = buildNameLabel();
		mediator.addLocalizableCompontent( nameLabel );
		mainWindow.add( nameLabel );
	}

	private LocalizableJFrame buildMainFrame( ComponentMediator mediator ) {
		
		LocalizableJFrame mainWindow
			= (LocalizableJFrame) ctx.getBean( "mainWindow" );
		mediator.addLocalizableCompontent( mainWindow );
		mainWindow.setLayout( new GridLayout( 3, 2 ) );
		return mainWindow;
	}
	
	public LocalizableJLabel buildNameLabel() {
		return (LocalizableJLabel) ctx.getBean( "nameLabel" );
	}
	
	public JTextField buildNameTextField() {
		return (JTextField) ctx.getBean( "nameTextField" );
	}
	
	public LocalizableJLabel buildAddressLabel() {
		return (LocalizableJLabel) ctx.getBean( "addressLabel" );
	}
	
	public JTextField buildAddressTextField() {
		return (JTextField) ctx.getBean( "addressTextField" );
	}
	
	public LocalizableJButton buildSubmitButton() {
		return (LocalizableJButton) ctx.getBean( "submitButton" );
	}
	
	@Override
	public void setApplicationContext( ApplicationContext ctx )
			throws BeansException {
		this.ctx = ctx;
	}
}
