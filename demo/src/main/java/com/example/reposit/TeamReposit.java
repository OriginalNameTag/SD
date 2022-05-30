package com.example.reposit;

import com.example.data.Team;

import org.springframework.data.repository.CrudRepository;

public interface TeamReposit extends CrudRepository<Team, Integer> {
    
}
