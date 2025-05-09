package ch.fhnw.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import ch.fhnw.pizza.business.service.LeagueService;
import ch.fhnw.pizza.business.service.PlayerService;
import ch.fhnw.pizza.business.service.RankingService;
import ch.fhnw.pizza.business.service.TeamService;
import io.swagger.v3.oas.annotations.Hidden;

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
}
