package ch.fhnw.pizza.business.service;//

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.fhnw.pizza.data.domain.League;
import ch.fhnw.pizza.data.repository.LeagueRepository;

import java.util.List;

@Service
public class LeagueService {

    @Autowired
    private LeagueRepository leagueRepository;

    public List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }

    public League getLeagueById(Long id) {
        return leagueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("League with id " + id + " not found"));
    }

    public League addLeague(League league) {
        return leagueRepository.save(league);
    }

    public League updateLeague(String id, League league) {
        League existingLeague = getLeagueById(id);
        if (league.getName() != null) {
            existingLeague.setName(league.getName());
        }
        // Update other fields as needed
        return leagueRepository.save(existingLeague);
    }

    public void deleteLeague(String id) {
        if (leagueRepository.existsById(id)) {
            leagueRepository.deleteById(id);
        } else {
            throw new RuntimeException("League with id " + id + " does not exist");
        }
    }
}
