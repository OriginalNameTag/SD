package com.example.reposit;

import com.example.data.User;


import org.springframework.data.repository.CrudRepository;

public interface UserReposit extends CrudRepository<User, Integer> {
    
}
