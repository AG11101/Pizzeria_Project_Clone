package ch.fhnw.pizza.data.domain;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Team {

    @Id
    /*
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    */
    private Long teamId; // Auto-generated primary key
    private String teamName; 
    private int wins;
    private int losses;
    private int winsAfterExtraTime;
    private int lossesAfterExtraTime;
    private int goalsScored;
    private int goalsConceded;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore     // Prevents circular references during JSON serialization
    private List<Player> players; // A team has many players

    
    @OneToMany(mappedBy = "team")
    private List<Ranking> rankings;
    

    @ManyToOne
    @JoinColumn(name = "league_id") // Foreign key column in the Team table
    @JsonIgnore   // Prevents circular references during JSON serialization     
    private League league; // A team belongs to one league

    // Getters and Setters
 
    public Long getId() {
        return teamId;
    }

    public void setId(Long id) {
        this.teamId = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTotalPoints() {
        return (wins * 3) + (winsAfterExtraTime * 2) + (lossesAfterExtraTime * 1);
    }

    public void setTotalPoints(int totalPoints) {
        // Intentionally left blank to match the style of setGoalStatistic
    }

    public int getGamesPlayed() {
        return wins + losses + winsAfterExtraTime + lossesAfterExtraTime;
    }

    public void setGamesPlayed(int gamesPlayed) {
        // Intentionally left blank to match the style of setGoalStatistic
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getWinsAfterExtraTime() {
        return winsAfterExtraTime;
    }

    public void setWinsAfterExtraTime(int winsAfterExtraTime) {
        this.winsAfterExtraTime = winsAfterExtraTime;
    }

    public int getLossesAfterExtraTime() {
        return lossesAfterExtraTime;
    }

    public void setLossesAfterExtraTime(int lossesAfterExtraTime) {
        this.lossesAfterExtraTime = lossesAfterExtraTime;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public void setGoalStatistic(int goalStatistic) {
    }
    public int getGoalStatistic() {
        return goalsScored - goalsConceded;
    }    
}

