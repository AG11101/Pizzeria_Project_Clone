package ch.fhnw.pizza.data.domain;

public class Ranking {
    private int rank; // The rank position
    private Team team; // Associated team
    private League league; // Associated league
    private int points; // Points of the team in the ranking

    // Getters and Setters
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
