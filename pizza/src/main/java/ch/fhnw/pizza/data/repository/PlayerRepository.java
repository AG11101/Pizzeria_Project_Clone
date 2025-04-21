package ch.fhnw.pizza.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.fhnw.pizza.data.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
    Player findByName(String name);
}
