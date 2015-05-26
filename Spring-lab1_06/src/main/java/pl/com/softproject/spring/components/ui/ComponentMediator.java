package pl.com.softproject.spring.components.ui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.JButton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;


public class ComponentMediator {

	private static final String MESSAGE_SOURCE_BEAN_NAME = "messageSource";
	
	private static final Locale ENGLISH_LOCALE = new Locale( "en", "EN" );
	
	private static final Locale POLISH_LOCALE = new Locale( "pl", "PL" );
	
	private ApplicationContext ctx;
	
	private Locale currentLocale;
	
	public ComponentMediator( ApplicationContext ctx ) {
		this.ctx = ctx;
		this.currentLocale = ENGLISH_LOCALE;
	}
	
	private List<Localizable> localizableCompontents
		= new ArrayList<Localizable>();
	
	public void addLocalizableCompontent( Localizable component ) {
		localizableCompontents.add( component );
	}
	
	public void addLocalizingButton( JButton button ) {
		button.setAction( new LocalizingAction( this ) );
	}
	
	public void doLocalization() {
		
		//TODO zrefaktoruj ponizszy fragment metody tak, aby
		//uwzglednial dodatkowa wersje jezykowa
		
		if ( currentLocale.equals( POLISH_LOCALE ) ) {
			currentLocale = ENGLISH_LOCALE;
		} else {
			currentLocale = POLISH_LOCALE;
		}
		
		final MessageSource messageSource = getMessageSource();
		
		for ( Localizable localizable : localizableCompontents ) {
			localizable.localize( messageSource, currentLocale );
		}
	}
	
	protected MessageSource getMessageSource() {
		return (MessageSource) ctx.getBean( MESSAGE_SOURCE_BEAN_NAME );
	}
	
	public class LocalizingAction extends AbstractAction {
		
		private ComponentMediator mediator;
		
		public LocalizingAction( ComponentMediator mediator ) {
			this.mediator = mediator;
		}
		
		@Override
		public void actionPerformed( ActionEvent e ) {
			mediator.doLocalization();
		}
		
	}
	
}
