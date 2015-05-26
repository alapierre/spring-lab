package pl.com.softproject.spring.components;

import java.util.Locale;

import javax.swing.JFrame;

import org.springframework.context.MessageSource;

import pl.com.softproject.spring.components.ui.Localizable;

public class LocalizableJFrame extends JFrame implements Localizable {
	
	private String titleKey;
	
	public LocalizableJFrame( String titleKey ) {
		this.titleKey = titleKey;
	}
	
	@Override
	public void localize( MessageSource messageSource, Locale locale ) {
		
		String title = messageSource
			.getMessage( titleKey, new Object[]{}, locale );
		
		setTitle( title );
		
		repaint();
	}

}
