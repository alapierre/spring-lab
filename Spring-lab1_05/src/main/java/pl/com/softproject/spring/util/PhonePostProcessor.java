package pl.com.softproject.spring.util;

import java.lang.reflect.Field;

import org.springframework.beans.BeansException;

import pl.com.softproject.spring.model.Phone;

public class PhonePostProcessor {

	public Object postProcessAfterInitialization( Object bean, String name )
			throws BeansException {
		return null;
	}

	private Phone extractPhone( Object bean ) {
		Phone result = null;

		Class<?> beanClazz = bean.getClass();

		try {

			Field theField = beanClazz.getDeclaredField( "phone" );
			boolean fieldExists = ( theField != null 
				&& theField.getType().equals( Phone.class ) );
			if ( fieldExists ) {
				theField.setAccessible( true );
				result = (Phone) theField.get( bean );
			}

		} catch ( SecurityException e ) {

			throw new RuntimeException( "Blad krytyczny", e );

		} catch ( NoSuchFieldException e ) {

			// calkowicie swiadomie ignorujemy blad!!!

		} catch ( IllegalArgumentException e ) {

			throw new RuntimeException( "Blad krytyczny", e );

		} catch ( IllegalAccessException e ) {

			throw new RuntimeException( "Blad krytyczny", e );
		}

		return result;
	}

	private void prettyPrintPhone( Phone phone ) {

		String formattedPhone = "+" +phone.getCountryNumber() + " ("
				+ phone.getAreaNumber() + ") " + phone.getPhoneNumber();

		System.out.println( formattedPhone );
	}

	public Object postProcessBeforeInitialization( Object bean, String name )
			throws BeansException {
		return bean;
	}
}
