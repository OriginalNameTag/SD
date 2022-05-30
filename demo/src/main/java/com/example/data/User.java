package com.example.data;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name="person")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private int phone;
    @Column(nullable = false)
    private Boolean admin;

    public User(){}

    public User(String name, String password, String email, Integer phone, Boolean admin){
        setName(name);
        setPassword(password);
        setEmail(email);
        setPhone(phone);
        setAdmin(admin);
    }

    public int getUserID(){
        return this.id;
    }
    public void setUserID(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public int getPhone(){
        return this.phone;
    }
    public void setPhone(int phone){
        this.phone = phone;
    }
    
    public boolean getAdmin(){
        return this.admin;
    }
    public void setAdmin(Boolean admin){
        this.admin = admin;
    }

    public String toString() {
        return getName() + "(id = " + getUserID() + "). Telephone: " + getPhone();
    }
}
