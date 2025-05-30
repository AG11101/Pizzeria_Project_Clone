package ch.fhnw.pizza.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import ch.fhnw.pizza.data.domain.Ranking;
import ch.fhnw.pizza.data.domain.Team;
import ch.fhnw.pizza.data.repository.RankingRepository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

@Service
public class RankingService {

    @Autowired
    private RankingRepository rankingRepository;

    public List<Ranking> getAllRankings() {
        return rankingRepository.findAll();
    }

    public Ranking getRankingById(Long id) {
        return rankingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ranking with id " + id + " not found"));
    }

    public Ranking addRanking(Ranking ranking) {
        return rankingRepository.save(ranking);
    }

    public Ranking updateRanking(Long id, Ranking ranking) {
        Ranking existingRanking = getRankingById(id);
        if (ranking.getRank() != 0) {
            existingRanking.setRank(ranking.getRank());
        }
        // Update other fields as needed
        return rankingRepository.save(existingRanking);
    }

    // pulls data from a JSON file
    private String jsonPath = "/api/rankings?jsonPath=/workspaces/Pizzeria_Project_Clone/pizza/src/main/resources/JSON NLA.json";

    public List<Ranking> calculateAndUpdateRankingsFromJson(String jsonPath) {
        if (jsonPath == null || jsonPath.isEmpty()) {
            throw new IllegalArgumentException("jsonPath must not be null or empty");
        }
    try {
        ObjectMapper mapper = new ObjectMapper();
        Team[] teams = mapper.readValue(Files.readAllBytes(Path.of(jsonPath)), Team[].class);

        // Rankings berechnen
        List<Ranking> rankings = new java.util.ArrayList<>();
        for (Team team : teams) {
            int score = team.getWins() + team.getGoalsScored();
            Ranking ranking = new Ranking();
            ranking.setTeam(team); // Team-Objekt setzen
            ranking.setPoints(score); // Punkte setzen
            rankings.add(ranking);
        }

        // Nach Punkten absteigend sortieren und Platzierung setzen
        rankings = rankings.stream()
                .sorted(Comparator.comparingInt(Ranking::getPoints).reversed())
                .collect(Collectors.toList());

        int platz = 1;
        for (Ranking r : rankings) {
            r.setRank(platz++); // Platzierung setzen
        }

        rankingRepository.deleteAll();
        rankingRepository.saveAll(rankings);

        return rankings;
    } catch (Exception e) {
        throw new RuntimeException("Fehler beim Laden oder Verarbeiten der Teamdaten: " + e.getMessage(), e);
    }
}
// ...existing code...

//Pulls data from the database
    @Autowired
private TeamService teamService; // Stelle sicher, dass TeamService verfügbar ist

public List<Ranking> calculateAndUpdateRankingsFromDbTeams() {
    List<Team> teams = teamService.getAllTeams();
    List<Ranking> rankings = new java.util.ArrayList<>();
    for (Team team : teams) {
        int score = team.getWins() + team.getGoalsScored();
        Ranking ranking = new Ranking();
        ranking.setTeam(team);
        ranking.setPoints(score);
        rankings.add(ranking);
    }
    rankings = rankings.stream()
            .sorted(Comparator.comparingInt(Ranking::getPoints).reversed())
            .collect(Collectors.toList());
    int platz = 1;
    for (Ranking r : rankings) {
        r.setRank(platz++);
    }
    rankingRepository.deleteAll();
    rankingRepository.saveAll(rankings);
    return rankings;
}

    public void deleteRanking(Long id) {
        if (rankingRepository.existsById(id)) {
            rankingRepository.deleteById(id);
        } else {
            throw new RuntimeException("Ranking with id " + id + " does not exist");
        }
    }
}
