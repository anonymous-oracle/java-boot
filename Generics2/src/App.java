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
        sportsGameTeam.addPlayer(p2);
        
        Team<FitnessPlayer> fitnessTeam = new Team<>("The fit team");
        fitnessTeam.addPlayer(p3);

        SportsPlayer p4 = new SportsPlayer("p4");
        SportsPlayer p5 = new SportsPlayer("p5");

        Team<SportsPlayer> sportsGameTeam2 = new Team<>("Sports Game Team 2");
        Team<SportsPlayer> sportsGameTeam3 = new Team<>("Sports Game Team 3");

        sportsGameTeam2.matchResult(sportsGameTeam3, 1, 0);
        sportsGameTeam2.matchResult(sportsGameTeam, 3, 8);

        


    }
}
