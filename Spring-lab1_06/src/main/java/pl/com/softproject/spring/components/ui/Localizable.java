package pl.com.softproject.spring.components.ui;

import java.util.Locale;

import org.springframework.context.MessageSource;

public interface Localizable {
	
	public void localize( MessageSource messageSource, Locale locale );
	
}
