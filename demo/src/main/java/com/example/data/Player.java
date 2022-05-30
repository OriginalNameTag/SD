package com.example.data;

import java.util.ArrayList;
import java.util.List;


import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name="player")
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String position;
    @Column(nullable = false)
    private Date birthday;
    @Column(nullable = false)
    private Integer goals;

    @ManyToOne()
    private Team team;
    

    public Player(){}
    
    public Player(String name, String position, Date birthday, Integer goals){
        setName(name);
        setPosition(position);
        setBirthday(birthday);
        setGoals(goals);
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getPosition(){
        return this.position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public Date getBirthday(){
        return this.birthday;
    }
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }

    public Integer getGoals(){
        return this.goals;
    }

    public void setGoals(Integer goals){
        this.goals = goals;
    }

    
    
}