package pl.sda.worldcup;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private final List<Team> teams = new ArrayList<Team>();
    private final List<Game> games = new ArrayList<Game>();
    private final String name;

    public Group(String name) {
        this.name = name;
    }

    public void addGame(Team home, Team away, int homeScore, int awayScore) {
        this.games.add(new Game(home, away, homeScore, awayScore));
    }

    public void addTeam(Team team) {
        this.teams.add(team);
    }

    public void printGames() {
        System.out.printf("\n\nGames in group %s:\n", name);
        games.stream().map(game -> String.format("%s %d : %d %s",
                game.getHome().getName(), game.getHomeScore(),
                game.getAwayScore(), game.getAway().getName())).forEach(System.out::println);

    }

    public void printTable() {

    }
}
