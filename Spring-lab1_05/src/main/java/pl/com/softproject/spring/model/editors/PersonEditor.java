package pl.com.softproject.spring.model.editors;

import java.beans.PropertyEditorSupport;
import pl.com.softproject.spring.model.Person;

public class PersonEditor extends PropertyEditorSupport {

	@Override
	public void setAsText( String text ) throws IllegalArgumentException {

            Person p = new Person();
            
            String[] res = text.split(";");
            
            p.setId(Long.parseLong(res[0]));
            p.setName(res[1]);
            p.setSurname(res[2]);
            
            setValue(p);
            
	}
	
}
