package ch.fhnw.pizza.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.fhnw.pizza.data.domain.Ranking;
import ch.fhnw.pizza.data.repository.RankingRepository;

import java.util.List;

@Service
public class RankingService {

    @Autowired
    private RankingRepository rankingRepository;

    public List<Ranking> getAllRankings() {
        return rankingRepository.findAll();
    }

    public Ranking getRankingById(Long id) {
        return rankingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ranking with id " + id + " not found"));
    }

    public Ranking addRanking(Ranking ranking) {
        return rankingRepository.save(ranking);
    }

    public Ranking updateRanking(Long id, Ranking ranking) {
        Ranking existingRanking = getRankingById(id);
        if (ranking.getRank() != 0) {
            existingRanking.setRank(ranking.getRank());
        }
        // Update other fields as needed
        return rankingRepository.save(existingRanking);
    }

    public void deleteRanking(Long id) {
        if (rankingRepository.existsById(id)) {
            rankingRepository.deleteById(id);
        } else {
            throw new RuntimeException("Ranking with id " + id + " does not exist");
        }
    }
}
