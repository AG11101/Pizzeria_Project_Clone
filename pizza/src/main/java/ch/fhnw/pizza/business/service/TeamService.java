package ch.fhnw.pizza.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.fhnw.pizza.data.domain.Team;
import ch.fhnw.pizza.data.repository.TeamRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team with id " + id + " not found"));
    }

    public Team addTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team updateTeam(Long id, Team team) {
        Team existingTeam = getTeamById(id);

        if (team.getTeamName() != null) {
            existingTeam.setTeamName(team.getTeamName());
        }
        if (team.getTotalPoints() != 0) {
            existingTeam.setTotalPoints(team.getTotalPoints());
        }
        if (team.getGamesPlayed() != 0) {
            existingTeam.setGamesPlayed(team.getGamesPlayed());
        }
        if (team.getWins() != 0) {
            existingTeam.setWins(team.getWins());
        }
        if (team.getLosses() != 0) {
            existingTeam.setLosses(team.getLosses());
        }
        if (team.getWinsAfterExtraTime() != 0) {
            existingTeam.setWinsAfterExtraTime(team.getWinsAfterExtraTime());
        }
        if (team.getLossesAfterExtraTime() != 0) {
            existingTeam.setLossesAfterExtraTime(team.getLossesAfterExtraTime());
        }
        if (team.getGoalsScored() != 0) {
            existingTeam.setGoalsScored(team.getGoalsScored());
        }
        if (team.getGoalsConceded() != 0) {
            existingTeam.setGoalsConceded(team.getGoalsConceded());
        }
        if (team.getPlayers() != null) {
            existingTeam.setPlayers(team.getPlayers());
        }
        if (team.getLeague() != null) {
            existingTeam.setLeague(team.getLeague());
        }

        return teamRepository.save(existingTeam);
    }

    public void deleteTeam(Long id) {
        if (teamRepository.existsById(id)) {
            teamRepository.deleteById(id);
        } else {
            throw new RuntimeException("Team with id " + id + " does not exist");
        }
    }
}
