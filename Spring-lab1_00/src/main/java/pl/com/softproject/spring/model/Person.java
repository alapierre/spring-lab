package pl.com.softproject.spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Person {

    @Value("#{1 + 3}")
    private Long id = 0l;

    private String name = "Jan";

    @Value("#{address.street}")
    private String surname = "Kowalski";

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", surname=" + surname + '}';
    }

    public String getName() {

        return name;
    }

    public String getSurname() {

        return surname;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

}
