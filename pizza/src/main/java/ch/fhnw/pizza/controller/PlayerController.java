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
    public ResponseEntity<Player> getPlayerById(@PathVariable String id) {
        return ResponseEntity.ok(playerService.getPlayerById(id));
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.addPlayer(player));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable String id, @RequestBody Player player) {
        return ResponseEntity.ok(playerService.updatePlayer(id, player));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable String id) {
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }
}
