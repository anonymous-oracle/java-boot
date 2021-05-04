public class App {
    public static void main(String[] args) {
        VideoGamePlayer p1 = new VideoGamePlayer("p1");
        SportsPlayer p2 = new SportsPlayer("p2");
        FitnessPlayer p3 = new FitnessPlayer("p3");
        Team<VideoGamePlayer> team = new Team<>("team");

        team.addPlayer(p1);
        // team.addPlayer(p2);
        // team.addPlayer(p3);

        System.out.println(team.numPlayers());

        Team<VideoGamePlayer> videoGameTeam = new Team<>("Video Game Team");
        videoGameTeam.addPlayer(p1);

        Team<SportsPlayer> sportsGameTeam = new Team<>("Sports Game Team");
        videoGameTeam.addPlayer(p2);


    }
}
