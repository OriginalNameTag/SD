package com.example.demo;

import com.example.data.User;
import com.example.demo.UserService;
import com.example.reposit.UserReposit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    @Autowired
    private UserReposit userReposit;
    
    public List<User> getAllUsers(){
        List<User>userRecords = new ArrayList<>();
        userReposit.findAll().forEach(userRecords::add);
        return userRecords; 
    }
    public User getUser(String email, String password){
        List<User>userRecords = new ArrayList<>();
        userReposit.findAll().forEach(userRecords::add);

        for(User user: userRecords){
            if(user.getEmail().equals(email) & user.getPassword().equals(password)){
               return user;
            }
        }
        return null;
    }
    public String addUser(User user){
        List<User>userRecords = new ArrayList<>();
        userReposit.findAll().forEach(userRecords::add);
        
        
        for(User userRecord: userRecords){
            if(userRecord.getName().equals(user.getName())){

            }
        }
        userReposit.save(user);
        return "registered";
    }
}
