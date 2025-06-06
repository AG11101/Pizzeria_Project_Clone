package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.business.service.PlayerService;
import ch.fhnw.pizza.data.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.getPlayerById(id));
    }

    @PostMapping
    public ResponseEntity<?> addPlayer(@RequestBody Player player) {
        Player savedPlayer = playerService.addPlayer(player);
        return ResponseEntity.ok(java.util.Collections.singletonMap("Added Team with ID:", savedPlayer.getId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePlayer(@PathVariable Long id, @RequestBody Player player) {
        Player updatedPlayer = playerService.updatePlayer(id, player);
        return ResponseEntity.ok(java.util.Collections.singletonMap("Updated Player with ID:", updatedPlayer.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok(java.util.Collections.singletonMap("deletedId", id));
    }
}
