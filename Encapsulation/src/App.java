public class App {
    public static void main(String[] args) throws Exception {
        // Player player = new Player();
        // player.name = "Tim";
        // player.health = 20;
        // player.weapon = "Sword";

        // int damage = 10;
        // player.loseHealth(damage);
        // System.out.println("Remaining health = " + player.healthRemaining());

        EnhancedPlayer player = new EnhancedPlayer("Doom", 50, "Sword");
        System.out.println("Initial health of player: " + player.getHealth());
    }
}
