/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.model;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author S108_8
 */
public class Vendor extends BaseEntity {

    @OneToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;
    private String email;
    private String numberPhone;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

}
