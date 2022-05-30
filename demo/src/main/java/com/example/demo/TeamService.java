package com.example.demo;

import com.example.data.Team;
import com.example.reposit.TeamReposit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    
    @Autowired
    private TeamReposit teamReposit;

    public void addTeam(Team team){
        teamReposit.save(team);
    }
}
