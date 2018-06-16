package pl.sda.worldcup;

import java.util.ArrayList;
import java.util.List;

public class WorldCupMain {

    private final List<Group> groups = new ArrayList<Group>();
    public static void main(String[] args) {
        new WorldCupMain().run();
    }

    private void run() {
        Team russia = new Team("Russia");
        Team saudiArabia = new Team("Saudi Arabia");
        Team egypt = new Team("Egypt");
        Team uruguay = new Team("Uruguay");

        Group groupA = new Group("A");
        groupA.addTeam(russia);
        groupA.addTeam(saudiArabia);
        groupA.addTeam(egypt);
        groupA.addTeam(uruguay);
        groups.add(groupA);

        groupA.addGame(russia, saudiArabia, 5, 0);
        groupA.addGame(uruguay, egypt, 1, 0);
        groupA.printGames();

        Team spain = new Team("Spain");
        Team portugal = new Team("Portugal");
        Team iran = new Team("Iran");
        Team morocco = new Team("Morocco");

        Group groupB = new Group("B");
        groupB.addTeam(spain);
        groupB.addTeam(portugal);
        groupB.addTeam(iran);
        groupB.addTeam(morocco);
        groups.add(groupB);

        groupB.addGame(iran, morocco, 1, 0);
        groupB.addGame(spain, portugal, 3, 3);
        groupB.printGames();
    }
}
