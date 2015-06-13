package pl.com.softproject.spring.lab1_08.model;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "client")
public class Client extends BaseEntity {
    
    @Size(max=64)
    private String name;
    
    @Size(max=128)
    private String lastName;
    
    @OneToMany(mappedBy="adresses")
    private Set<Address> addresses = new LinkedHashSet<>();
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
   
}
