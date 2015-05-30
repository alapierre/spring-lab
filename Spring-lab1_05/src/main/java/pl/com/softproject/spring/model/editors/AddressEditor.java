package pl.com.softproject.spring.model.editors;

import java.beans.PropertyEditorSupport;
import pl.com.softproject.spring.model.Address;

public class AddressEditor extends PropertyEditorSupport {
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        
        Address address = new Address();
        
        String[] res = text.split(";");
        
        address.setId(Long.parseLong(res[0]));
        address.setStreet(res[1]);
        address.setNumber(res[2]);
        address.setPostalCode(res[3]);
        address.setCity(res[4]);
        
        setValue(address);
        
    }
    
}
