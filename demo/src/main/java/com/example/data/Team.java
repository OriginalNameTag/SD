package com.example.data;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name="team")
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String image;
    @OneToMany(mappedBy = "team")
    private List<Player> players;
    @ManyToMany(mappedBy = "teams")
    private List<Game> games;

    public Team(){}

    public Team(String name, String image){
        setName(name);
        setImage(image);
    }

    public int getID(){
        return this.id;
    }
    public void setID(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getImage(){
        return this.image;
    }
    public void setImage(String image){
        this.image = image;
    }

    public void addPlayer(Player player){
        players.add(player);
    }
    public List<Player> getPlayers(){
       return this.players; 
    }

    //Jogos da equipa (total, vitorias, derrotas, empates)
    public int[] getJogos(){
        int j = 0, v = 0, d = 0, e = 0;
        for(Game game: games){
            for(Team team: game.getTeam()){
                if(Objects.equals(team.getName(), this.name)){
                    j++;
                    if(Objects.equals(game.getWinner(), this.name)){
                        v++;
                    } else if(Objects.equals(game.getLoser(), this.name)){
                        d++;
                    } else{
                        e++;
                    }
                }
            }
        }
        return new int[]{j, v, d, e};
    }

    //Melhor marcador
    public String getMelhorMarcador(){
        String nome = "";
        int golos = -1;
        for(Player player: players){
            if(player.getGoals() > golos){
                nome = player.getName();
            }
        }
        return nome;
    }
}
