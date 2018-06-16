package pl.sda.worldcup;

public class Game {

    Team home;
    Team away;
    int homeScore;
    int awayScore;

    public Game(Team home, Team away, int homeScore, int awayScore) {
        this.home = home;
        this.away = away;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public Team getHome() {
        return home;
    }

    public Team getAway() {
        return away;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (homeScore != game.homeScore) return false;
        if (awayScore != game.awayScore) return false;
        if (home != null ? !home.equals(game.home) : game.home != null) return false;
        return away != null ? away.equals(game.away) : game.away == null;
    }

    @Override
    public int hashCode() {
        int result = home != null ? home.hashCode() : 0;
        result = 31 * result + (away != null ? away.hashCode() : 0);
        result = 31 * result + homeScore;
        result = 31 * result + awayScore;
        return result;
    }
}
