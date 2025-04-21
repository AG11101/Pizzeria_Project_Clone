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

    public Player getPlayerById(String id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player with id " + id + " not found"));
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(String id, Player player) {
        Player existingPlayer = getPlayerById(id);
        if (player.getName() != null) {
            existingPlayer.setName(player.getName());
        }
        if (player.getLastName() != null) {
            existingPlayer.setLastName(player.getLastName());
        }
        // Update other fields as needed
        return playerRepository.save(existingPlayer);
    }

    public void deletePlayer(String id) {
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Player with id " + id + " does not exist");
        }
    }
}
