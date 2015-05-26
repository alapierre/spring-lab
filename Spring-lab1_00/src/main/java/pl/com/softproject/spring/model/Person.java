
package pl.com.softproject.spring.model;


import org.apache.commons.lang.builder.ToStringBuilder;

public class Person{

	private Long id = 0l;
	
	private String name = "Jan";

	private String surname = "Kowalski";
	
	@Override
	public String toString() {
		
		return ToStringBuilder.reflectionToString( this );
	}
	
	public String getName() {

		return name;
	}

	public String getSurname() {

		return surname;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public void setSurname( String surname ) {

		this.surname = surname;
	}

	public Long getId() {
	
		return id;
	}
	
	public void setId( Long id ) {
	
		this.id = id;
	}

}
