package com.example.data;

import java.util.ArrayList;
import java.util.List;

import java.security.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name="game")
public class Game {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private Timestamp gameDate;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String winner;
    @Column(nullable = false)
    private String loser;
    @ManyToMany()
    private List<Team> teams;

    public Game(){}

    public Game(Timestamp gameDate, String location){
        setGameDate(gameDate);
        setLocation(location);
        this.teams = new ArrayList<>();
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getWinner() {return this.winner;}
    public void setWinner(String team) { this.winner = winner;}
    public String getLoser() {return this.loser;}
    public void setLoser(String team) { this.loser = loser;}

    public Timestamp getGameDate(){
        return this.gameDate;
    }
    public void setGameDate(Timestamp gameDate){
        this.gameDate = gameDate;
    }

    public String getLocation(){
        return this.location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    @XmlElementWrapper(name="team")
    @XmlElement(name="team")
    public List<Team> getTeam(){
        return teams;
    }
    public void setTeam(List<Team> teams){
        this.teams = teams;
    }
    public void addTeam(Team team){
        this.teams.add(team);
    }
}
