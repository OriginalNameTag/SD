package com.example.reposit;

import com.example.data.Player;

import org.springframework.data.repository.CrudRepository;

public interface PlayerReposit extends CrudRepository<Player, Integer> {
    
}
