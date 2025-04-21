package ch.fhnw.pizza.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.fhnw.pizza.data.domain.Ranking;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, Long> {
    Ranking findByRank(int rank);
}
