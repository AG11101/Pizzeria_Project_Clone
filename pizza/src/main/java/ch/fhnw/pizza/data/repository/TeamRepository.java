package ch.fhnw.pizza.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.fhnw.pizza.data.domain.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    // Optional: Custom method to find by team name
    Team findByTeamName(String teamName);
}
