package ch.fhnw.pizza.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.fhnw.pizza.data.domain.Player;
import ch.fhnw.pizza.data.repository.PlayerRepository;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) { // Changed String to Long
        return playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player with id " + id + " not found"));
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, Player player) { // Changed String to Long
        Player existingPlayer = getPlayerById(id);
        if (player.getName() != null) {
            existingPlayer.setName(player.getName());
        }
        if (player.getLastName() != null) {
            existingPlayer.setLastName(player.getLastName());
        }
        if (player.getGoals() != 0) {
            existingPlayer.setGoals(player.getGoals());
        }
        if (player.getAssists() != 0) {
            existingPlayer.setAssists(player.getAssists());
        }
        if (player.getTeam() != null) {
            existingPlayer.setTeam(player.getTeam());
        }
        return playerRepository.save(existingPlayer);
    }

    public void deletePlayer(Long id) { // Changed String to Long
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Player with id " + id + " does not exist");
        }
    }
}
