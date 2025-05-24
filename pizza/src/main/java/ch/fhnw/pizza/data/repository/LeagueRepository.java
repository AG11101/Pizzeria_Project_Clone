package ch.fhnw.pizza.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.fhnw.pizza.data.domain.League;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {
    League findByName(String name); // Updated method name to match the 'name' property
}
