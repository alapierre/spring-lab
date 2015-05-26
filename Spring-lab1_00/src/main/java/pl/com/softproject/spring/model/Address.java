package pl.com.softproject.spring.model;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Address{

	private Long id = 0l;
	
	private String street = "Stawki";
	
	private String number = "2";
	
	private String city = "Warszawa";
	
	private String postalCode = "00-193";

	
	@Override
	public String toString() {
		
		return ToStringBuilder.reflectionToString( this );
	}
	
	public void setStreet( String street ) {
	
		this.street = street;
	}

	
	public void setNumber( String number ) {
	
		this.number = number;
	}

	
	public void setCity( String city ) {
	
		this.city = city;
	}

	
	public void setPostalCode( String postalCode ) {
	
		this.postalCode = postalCode;
	}

	
	public String getStreet() {
	
		return street;
	}

	
	public String getNumber() {
	
		return number;
	}

	
	public String getCity() {
	
		return city;
	}

	
	public String getPostalCode() {
	
		return postalCode;
	}

	public Long getId() {
	
		return id;
	}

	
	public void setId( Long id ) {
	
		this.id = id;
	}
	
}
