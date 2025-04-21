package ch.fhnw.pizza.data.domain;


//Implement @Entity to create the respective H2 databse table
public class Player {
    private String playerId; // Unique identifier for the player
    private String name; // Player's name
    private String lastName; // Player's last name
    private int goals; // Number of goals scored by the player
    private int assists; // Number of assists by the player

    // Getters and Setters
    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }
}
