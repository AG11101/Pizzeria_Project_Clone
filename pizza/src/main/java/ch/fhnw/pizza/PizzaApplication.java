package ch.fhnw.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import ch.fhnw.pizza.business.service.LeagueService;
import ch.fhnw.pizza.business.service.PlayerService;
import ch.fhnw.pizza.business.service.RankingService;
import ch.fhnw.pizza.business.service.TeamService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.PostConstruct;

import ch.fhnw.pizza.data.domain.Team;
import ch.fhnw.pizza.data.domain.Player;

@SpringBootApplication
@RestController
@Hidden // Hide this controller from the Swagger UI
public class PizzaApplication {

    // Autowire other services here
    private final LeagueService leagueService;
    private final PlayerService playerService;
    private final RankingService rankingService;
    private final TeamService teamService;

    public PizzaApplication(LeagueService leagueService, PlayerService playerService, RankingService rankingService, TeamService teamService) {
        this.leagueService = leagueService;
        this.playerService = playerService;
        this.rankingService = rankingService;
        this.teamService = teamService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PizzaApplication.class, args);
    }

    @PostConstruct
    private void initPlaceholderData() throws Exception {
        // Example: create or fetch teams first
        Team wasa = new Team();
        wasa.setTeamName("WASA St. Gallen");
        teamService.addTeam(wasa);

        Team gc = new Team();
        gc.setTeamName("Grasshopper Club Zürich");
        teamService.addTeam(gc);

        // Player 1
        Player player = new Player();
        player.setPlayerId("NLA - 270");
        player.setName("Santtu");
        player.setLastName("Vuoristo");
        player.setTeam(wasa);
        player.setGoals(9);
        player.setAssists(9);
        playerService.addPlayer(player);

        // Player 2
        player = new Player();
        player.setPlayerId("NLA - 195");
        player.setName("Maxim");
        player.setLastName("Frei");
        player.setTeam(gc);
        player.setGoals(0);
        player.setAssists(0);
        playerService.addPlayer(player);

        // Add more players as needed...
    }
}
