package ch.fhnw.pizza.data.domain;

import java.util.List;

public class League {
    private String leagueName; // Name of the league
    private List<Team> teams; // List of teams participating in the league
    private List<Ranking> rankings; // Rankings associated with the league

    // Getters and Setters
    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Ranking> getRankings() {
        return rankings;
    }

    public void setRankings(List<Ranking> rankings) {
        this.rankings = rankings;
    }
}
