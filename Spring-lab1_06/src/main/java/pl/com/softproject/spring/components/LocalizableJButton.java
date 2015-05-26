package pl.com.softproject.spring.components;

import java.util.Locale;

import javax.swing.JButton;

import org.springframework.context.MessageSource;

import pl.com.softproject.spring.components.ui.Localizable;

public class LocalizableJButton extends JButton
		implements Localizable {
	
	private String textKey;
	
	public LocalizableJButton( String textKey ) {
		this.textKey = textKey;
	}
	
	@Override
	public void localize( MessageSource messageSource, Locale locale ) {
		final String text = messageSource
			.getMessage( textKey, new Object[]{}, locale );
		
		setText( text );
		repaint();
	}

	
}
