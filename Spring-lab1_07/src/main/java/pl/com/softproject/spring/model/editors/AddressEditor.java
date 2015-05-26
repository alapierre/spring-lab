package pl.com.softproject.spring.model.editors;

import java.beans.PropertyEditorSupport;
import java.util.StringTokenizer;

import pl.com.softproject.spring.model.Address;

public class AddressEditor extends PropertyEditorSupport {

	@Override
	public void setAsText( String text ) throws IllegalArgumentException {
		//Zaimplementuj metode. Przeksztalc lancuch znakow na obiekt Address
		StringTokenizer tokenizer = new StringTokenizer(text,";");
		Address address = new Address();
		address.setId(Long.valueOf(tokenizer.nextToken()));
		address.setStreet(tokenizer.nextToken());
		address.setNumber(tokenizer.nextToken());
		address.setPostalCode(tokenizer.nextToken());
		address.setCity(tokenizer.nextToken());
		setValue(address);
	}
	
	
}

