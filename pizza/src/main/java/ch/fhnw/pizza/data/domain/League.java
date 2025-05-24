package ch.fhnw.pizza.data.domain;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class League {

    @Id // Marks this field as the primary key
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key
    private Long id; 
    private String name; // This is the property being queried
    private String country; // Country where the league is located

    @OneToMany(mappedBy = "league", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore    
    private List<Team> teams; // A league has many teams

    // Getters and Setters
    public Long getLeagueId() {
        return id;
    }

    public void setLeagueId(Long leagueId) {
        this.id = leagueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }


}



