package ch.fhnw.pizza.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.fhnw.pizza.data.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> { // Use Long as the primary key type
    Player findByName(String name);
}
