import java.util.ArrayList;

// public class Team<T> {
public class Team<T extends Player> { // this restricts the class to only the player types
    // public class Team<T extends Player & Teacher & Keeper > implements Comparable<Team<T>> { // use this syntax
    // to first extend the desired class followed by a sequence of interfaces
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on this team");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            this.won++;
        } else if (ourScore == theirScore) {
            this.tied++;
        } else {
            this.lost++;
        }
        played++;
        if (opponent != null) {
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        return (this.won * 2) + tied;
    }

    public int numPlayers() {
        return this.members.size();
    }
}
