package ch.fhnw.pizza.data.domain;

import jakarta.persistence.*;

@Entity
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Internal identifier

    private int rank;

    @ManyToOne
    @JoinColumn(name = "team_id") // Foreign key column in the Ranking table
    private Team team;

    @ManyToOne
    @JoinColumn(name = "league_id") // Foreign key column in the Ranking table
    private League league;

    private int points;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
