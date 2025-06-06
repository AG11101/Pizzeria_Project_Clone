package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.business.service.TeamService;
import ch.fhnw.pizza.data.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.getTeamById(id));
    }

    @PostMapping
    public ResponseEntity<?> addTeam(@RequestBody Team team) {
        Team savedTeam = teamService.addTeam(team);
        return ResponseEntity.ok(java.util.Collections.singletonMap("Added a Team with ID:", savedTeam.getId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeam(@PathVariable Long id, @RequestBody Team team) {
        Team updatedTeam = teamService.updateTeam(id, team);
        return ResponseEntity.ok(java.util.Collections.singletonMap("Updated Team with ID:", updatedTeam.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.ok(java.util.Collections.singletonMap("deletedId", id));
    }
}