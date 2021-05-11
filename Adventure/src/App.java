import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, String> exitChoices = new HashMap<String, String>();

    public static void main(String[] args) {
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);
        locations.get(1).addExit("Q", 0);

        locations.get(2).addExit("N", 5);
        locations.get(2).addExit("Q", 0);

        locations.get(3).addExit("W", 1);
        locations.get(3).addExit("Q", 0);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);
        locations.get(4).addExit("Q", 0);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
        locations.get(5).addExit("Q", 0);

        int loc = 1;
        Map<String, Integer> exits;
        String direction;
        exitChoices.put("N", "NORTH");
        exitChoices.put("S", "SOUTH");
        exitChoices.put("E", "EAST");
        exitChoices.put("W", "WEST");
        exitChoices.put("Q", "QUIT");

        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }

            exits = locations.get(loc).getExits();
            System.out.println("Available exits are: ");
            exits.forEach((k, v) -> {
                System.out.println(k + " for " + exitChoices.get(k));
            });
            // TEST SENTENCE
            // run all the way towards south
            // run towards south all the way
            direction = scanner.nextLine().toUpperCase();
            direction = directionExtractor(direction);

            // scanner.nextLine();
            // loc = scanner.nextInt();
            if (exits.containsKey(direction.substring(0, 1))) {
                loc = exits.get(direction.subSequence(0, 1));
            } else if (direction.equals("")) {
                System.out.println("Choose a valid direction");
            }

            // if (!locations.containsKey(loc)) {
            // System.out.println("You cannot go in that direction");
            // loc = 1;
            // }
        }

    }

    public static String directionExtractor(String direction) {
        String[] splits = direction.split(" ");
        String returnDirection = "";
        String word = null;
        for (String string : splits) {
            word = string.toUpperCase();
            switch (word.substring(0, 1)) {
                case "N":
                    if (returnDirection == "") {
                        returnDirection = directionMatcher(word);
                    }
                    break;
                case "S":
                if (returnDirection == "") {
                    returnDirection = directionMatcher(word);
                }
                    break;
                case "E":
                if (returnDirection == "") {
                    returnDirection = directionMatcher(word);
                }
                    break;
                case "W":
                if (returnDirection == "") {
                    returnDirection = directionMatcher(word);
                }
                    break;
                case "Q":
                if (returnDirection == "") {
                    returnDirection = directionMatcher(word);
                }
                    break;
                default:
                    continue;
            }
        }
        return returnDirection;

    }

    public static String directionMatcher(String word) {
        String returnDirection = exitChoices.get(word.substring(0, 1));
        if (returnDirection.equals(word)) {
            return word;
        }
        return "";
    }
}
