package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.business.service.RankingService;
import ch.fhnw.pizza.data.domain.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rankings")
public class RankingController {

    @Autowired
    private RankingService rankingService;

    // ...existing code...
@GetMapping
public List<Ranking> getAllRankings(@RequestParam(required = false) String jsonPath) {
    if (jsonPath != null) {
        // Rankings immer neu berechnen, wenn jsonPath übergeben wurde
        return rankingService.calculateAndUpdateRankingsFromJson(jsonPath);
    }
    // Ansonsten Rankings aus der DB zurückgeben
    return rankingService.getAllRankings();
}
// ...existing code...

    @GetMapping("/{id}")
    public ResponseEntity<Ranking> getRankingById(@PathVariable Long id) {
        return ResponseEntity.ok(rankingService.getRankingById(id));
    }

    @PostMapping
    public ResponseEntity<Ranking> addRanking(@RequestBody Ranking ranking) {
        return ResponseEntity.ok(rankingService.addRanking(ranking));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ranking> updateRanking(@PathVariable Long id, @RequestBody Ranking ranking) {
        return ResponseEntity.ok(rankingService.updateRanking(id, ranking));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRanking(@PathVariable Long id) {
        rankingService.deleteRanking(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/calculate")
    public List<Ranking> calculateRankingsFromDb() {
    return rankingService.calculateAndUpdateRankingsFromDbTeams();
}
}
