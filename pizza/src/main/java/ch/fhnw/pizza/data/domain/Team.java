package ch.fhnw.pizza.data.domain;

import java.util.List;

public class Team {
    private String teamName;
    private int totalPoints;
    private int gamesPlayed;
    private int wins;
    private int losses;
    private int winsAfterExtraTime;
    private int lossesAfterExtraTime;
    private int goalsScored;
    private int goalsConceded;
    private List<Player> players; // Association with Player
    private League league; // Association with League

    // Getters and Setters
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
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
}
