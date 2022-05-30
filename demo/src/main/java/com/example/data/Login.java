package com.example.data;

import java.io.Serializable;

public class Login implements Serializable {
    private String email;
    private String password;

    public Login(){}

    public Login(String email, String password){
        setEmail(email);
        setPassword(password);
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
