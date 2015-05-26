package pl.com.softproject.spring.components;

import java.util.Locale;

import javax.swing.JLabel;

import org.springframework.context.MessageSource;

import pl.com.softproject.spring.components.ui.Localizable;

public class LocalizableJLabel extends JLabel 
implements Localizable {

	private String textKey;
	
	public LocalizableJLabel( String textKey ) {
		this.textKey = textKey;
	}
	
	@Override
	public void localize( MessageSource messageSource, Locale locale ) {
		String text = messageSource
			.getMessage( textKey, new Object[]{}, locale );
		
		setText( text );
		
		repaint();
	}

}
