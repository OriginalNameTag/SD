package com.example.data;


import java.security.Timestamp;
import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name="event")
public class Event {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer type;
    @Column(nullable = false)
    private Timestamp eventTime;
    @ManyToOne(cascade = CascadeType.ALL)
    private Game game;
    @ManyToOne(cascade = CascadeType.ALL)
    private Team team;
    @ManyToOne(cascade = CascadeType.ALL)
    private Player player;

    public Event(){}

    public Event(Integer type, Timestamp eventTime){

        switch(type){
            //Inicio e Fim (Separar?)
            case 0:
                //Inicio: Mostrar tempo, equipas
                //Fim: mostrar resultado, tempo
                break;
            //Golo
            case 1:
                //Adicionar golo ao jogador
                //Adicionar golo ao resultado
                //Mostrar jogador, equipa e tempo do golo
                break;
            //Cartao Amarelo
            case 2:
                //Mostrar nome do jogador, tempo
                break;
            //Cartao Vermelho
            case 3:
                //Mostrar nome do jogador, tempo
                break;
            //Jogo Interrompido
            case 4:
                //Mostrar tempo
                break;
            //Jogo Resumido
            case 5:
                //Mostrar tempo
                break;
            default:
                break;
        }

    }
}
