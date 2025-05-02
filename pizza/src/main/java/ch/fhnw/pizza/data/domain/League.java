package ch.fhnw.pizza.data.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class League {

    @Id
    private String leagueId; // Primary key

    private String name;

    @OneToMany(mappedBy = "league", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Team> teams; // A league has many teams

    // Getters and Setters
    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
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


