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
import ch.fhnw.pizza.data.domain.League;
import ch.fhnw.pizza.data.domain.Player;

@SpringBootApplication
@RestController
@Hidden // Hide this controller from the Swagger UI
public class PizzaApplication {



    // Autowire other services here
    private final LeagueService leagueService;
    private final PlayerService playerService;
    private final TeamService teamService;

    public PizzaApplication(LeagueService leagueService, PlayerService playerService, RankingService rankingService, TeamService teamService) {
        this.leagueService = leagueService;
        this.playerService = playerService;
        this.teamService = teamService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PizzaApplication.class, args);
    }

    @PostConstruct
    private void initPlaceholderData() throws Exception {
        // Teams from JSON NLA with extended data
        Team gc = new Team();
        gc.setId(21L); 
        gc.setTeamName("Grasshopper Club Zürich");
        gc.setGamesPlayed(22);
        gc.setTotalPoints(33);
        gc.setWins(8);
        gc.setLosses(7);
        gc.setWinsAfterExtraTime(2);
        gc.setLossesAfterExtraTime(5);
        gc.setGoalStatistic(-1);
        gc.setGoalsScored(120);
        gc.setGoalsConceded(121);
        teamService.addTeam(gc);

        Team uster = new Team();
        uster.setId(22L);
        uster.setTeamName("UHC Uster");
        uster.setGamesPlayed(22);
        uster.setTotalPoints(34);
        uster.setWins(9);
        uster.setLosses(9);
        uster.setWinsAfterExtraTime(3);
        uster.setLossesAfterExtraTime(1);
        uster.setGoalStatistic(-11);
        uster.setGoalsScored(118);
        uster.setGoalsConceded(129);
        teamService.addTeam(uster);

        Team koeniz = new Team();
        koeniz.setId(23L);
        koeniz.setTeamName("Floorball Köniz Bern");
        koeniz.setGamesPlayed(22);
        koeniz.setTotalPoints(37);
        koeniz.setWins(11);
        koeniz.setLosses(7);
        koeniz.setWinsAfterExtraTime(0);
        koeniz.setLossesAfterExtraTime(4);
        koeniz.setGoalStatistic(10);
        koeniz.setGoalsScored(135);
        koeniz.setGoalsConceded(135);
        teamService.addTeam(koeniz);

        Team tigers = new Team();
        tigers.setId(24L);
        tigers.setTeamName("Tigers Langnau");
        tigers.setGamesPlayed(22);
        tigers.setTotalPoints(40);
        tigers.setWins(11);
        tigers.setLosses(6);
        tigers.setWinsAfterExtraTime(2);
        tigers.setLossesAfterExtraTime(3);
        tigers.setGoalStatistic(15);
        tigers.setGoalsScored(145);
        tigers.setGoalsConceded(130);
        teamService.addTeam(tigers);

        Team wasa = new Team();
        wasa.setId(25L); 
        wasa.setTeamName("WASA St.Gallen");
        wasa.setGamesPlayed(22);
        wasa.setTotalPoints(5);
        wasa.setWins(1);
        wasa.setLosses(19);
        wasa.setWinsAfterExtraTime(0);
        wasa.setLossesAfterExtraTime(2);
        wasa.setGoalStatistic(-50);
        wasa.setGoalsScored(110);
        wasa.setGoalsConceded(160);
        teamService.addTeam(wasa);

        Team alligator = new Team();
        alligator.setId(26L);
        alligator.setTeamName("UHC Alligator Malans");
        alligator.setGamesPlayed(22);
        alligator.setTotalPoints(30);
        alligator.setWins(8);
        alligator.setLosses(10);
        alligator.setWinsAfterExtraTime(2);
        alligator.setLossesAfterExtraTime(2);
        alligator.setGoalStatistic(-10);
        alligator.setGoalsScored(102);
        alligator.setGoalsConceded(113);
        teamService.addTeam(alligator);

        Team chur = new Team();
        chur.setId(27L);
        chur.setTeamName("Chur Unihockey");
        chur.setGamesPlayed(22);
        chur.setTotalPoints(26);
        chur.setWins(6);
        chur.setLosses(12);
        chur.setWinsAfterExtraTime(4);
        chur.setLossesAfterExtraTime(0);
        chur.setGoalStatistic(-16);
        chur.setGoalsScored(114);
        chur.setGoalsConceded(130);
        teamService.addTeam(chur);

        Team rychenberg = new Team();
        rychenberg.setId(28L);
        rychenberg.setTeamName("HC Rychenberg Winterthur");
        rychenberg.setGamesPlayed(22);
        rychenberg.setTotalPoints(41);
        rychenberg.setWins(12);
        rychenberg.setLosses(7);
        rychenberg.setWinsAfterExtraTime(2);
        rychenberg.setLossesAfterExtraTime(1);
        rychenberg.setGoalStatistic(12);
        rychenberg.setGoalsScored(128);
        rychenberg.setGoalsConceded(116);
        teamService.addTeam(rychenberg);

        Team thurgau = new Team();
        thurgau.setId(29L);
        thurgau.setTeamName("Floorball Thurgau");
        thurgau.setGamesPlayed(22);
        thurgau.setTotalPoints(38);
        thurgau.setWins(12);
        thurgau.setLosses(9);
        thurgau.setWinsAfterExtraTime(1);
        thurgau.setLossesAfterExtraTime(0);
        thurgau.setGoalStatistic(25);
        thurgau.setGoalsScored(140);
        thurgau.setGoalsConceded(115);
        teamService.addTeam(thurgau);

        Team basel = new Team();
        basel.setId(30L);
        basel.setTeamName("Unihockey Basel Regio");
        basel.setGamesPlayed(22);
        basel.setTotalPoints(11);
        basel.setWins(3);
        basel.setLosses(18);
        basel.setWinsAfterExtraTime(1);
        basel.setLossesAfterExtraTime(0);
        basel.setGoalStatistic(-74);
        basel.setGoalsScored(91);
        basel.setGoalsConceded(165);
        teamService.addTeam(basel);

        Team zug = new Team();
        zug.setId(31L);
        zug.setTeamName("Zug United");
        zug.setGamesPlayed(22);
        zug.setTotalPoints(51);
        zug.setWins(16);
        zug.setLosses(4);
        zug.setWinsAfterExtraTime(1);
        zug.setLossesAfterExtraTime(1);
        zug.setGoalStatistic(54);
        zug.setGoalsScored(161);
        zug.setGoalsConceded(107);
        teamService.addTeam(zug);

        Team wiler = new Team();
        wiler.setId(32L);
        wiler.setTeamName("SV Wiler-Ersigen");
        wiler.setGamesPlayed(22);
        wiler.setTotalPoints(50);
        wiler.setWins(14);
        wiler.setLosses(3);
        wiler.setWinsAfterExtraTime(3);
        wiler.setLossesAfterExtraTime(2);
        wiler.setGoalStatistic(46);
        wiler.setGoalsScored(153);
        wiler.setGoalsConceded(107);
        teamService.addTeam(wiler);


        // Add example players as before or extend as needed...
        // Player 1
        Player player = new Player();
        player.setId(1L);
        player.setName("Santtu");
        player.setLastName("Vuoristo");
        player.setTeam(wasa);
        player.setGoals(9);
        player.setAssists(9);
        player.getTotalPoints();
        playerService.addPlayer(player);
 
        // Player 2
        player = new Player();
        player.setId(2L);
        player.setName("Maxim");
        player.setLastName("Frei");
        player.setTeam(gc);
        player.setGoals(5);
        player.setAssists(2);
        player.getTotalPoints();
        playerService.addPlayer(player);

        // Player 3
        player = new Player();
        player.setId(3L);
        player.setName("Luca");
        player.setLastName("Müller");
        player.setTeam(wiler);
        player.setGoals(12);
        player.setAssists(15);
        player.getTotalPoints();
        playerService.addPlayer(player);

        // Player 4
        player = new Player();
        player.setId(4L);
        player.setName("Jonas");
        player.setLastName("Keller");
        player.setTeam(zug);
        player.setGoals(20);
        player.setAssists(8);
        player.getTotalPoints();
        playerService.addPlayer(player);

        // Player 5
        player = new Player();
        player.setId(5L);
        player.setName("Fabio");
        player.setLastName("Schmid");
        player.setTeam(koeniz);
        player.setGoals(7);
        player.setAssists(11);
        player.getTotalPoints();
        playerService.addPlayer(player);

        // Player 6
        player = new Player();
        player.setId(6L);
        player.setName("Simon");
        player.setLastName("Baumgartner");
        player.setTeam(tigers);
        player.setGoals(14);
        player.setAssists(10);
        player.getTotalPoints();
        playerService.addPlayer(player);

        // Player 7
        player = new Player();
        player.setId(7L);
        player.setName("Noah");
        player.setLastName("Meier");
        player.setTeam(uster);
        player.setGoals(9);
        player.setAssists(13);
        player.getTotalPoints();
        playerService.addPlayer(player);

        // Player 8
        player = new Player();
        player.setId(8L);
        player.setName("David");
        player.setLastName("Weber");
        player.setTeam(alligator);
        player.setGoals(6);
        player.setAssists(7);
        player.getTotalPoints();
        playerService.addPlayer(player);

        // Player 9
        player = new Player();
        player.setId(9L);
        player.setName("Samuel");
        player.setLastName("Fischer");
        player.setTeam(chur);
        player.setGoals(11);
        player.setAssists(5);
        player.getTotalPoints();
        playerService.addPlayer(player);

        // Player 10
        player = new Player();
        player.setId(10L);
        player.setName("Tim");
        player.setLastName("Brunner");
        player.setTeam(rychenberg);
        player.setGoals(8);
        player.setAssists(12);
        player.getTotalPoints();
        playerService.addPlayer(player);

        League nla = new League();
        nla.setLeagueId(31L);
        nla.setName("NLA");
        leagueService.addLeague(nla);
/*
 

         // Example Ranking for Grasshopper Club Zürich
        Ranking ranking = new Ranking();
        ranking.setRank(1);
        ranking.setTeam(gc); // gc is the Grasshopper Club Zürich team created above
        ranking.setLeague(nla);
        ranking.setPoints(gc.getTotalPoints());
        rankingService.addRanking(ranking);

        // Example Ranking for WASA St.Gallen
        Ranking ranking2 = new Ranking();
        ranking2.setRank(12);
        ranking2.setTeam(wasa);
        ranking2.setLeague(nla);
        ranking2.setPoints(wasa.getTotalPoints());
        rankingService.addRanking(ranking2);
 */
       
    }
}