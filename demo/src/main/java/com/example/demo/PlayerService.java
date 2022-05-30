package com.example.demo;

import com.example.data.Player;
import com.example.reposit.PlayerReposit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PlayerService {
    @Autowired
    private PlayerReposit playerReposit;

    public void addPlayer(Player player){
        playerReposit.save(player);
    }
}
