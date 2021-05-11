import java.security.Key;
import java.util.Map;
import java.util.function.BiConsumer;

public class App {
    public static void main(String[] args) throws Exception {

        Map<String, String> languages = new java.util.HashMap<>(); // Map is a base collection and HashMap is
                                                                   // implemented from Map
        languages.put("Java", "A compiled high level, object oriented, platform independent programming language");
        languages.put("Python", "an interpreted high level object oriented programming language");
        languages.put("C", "A compiled high level, modular, programming language");
        languages.put("C++", "A compiled high level, object oriented and statically typed, programming language");
        languages.put("Golang", "A compiled high level, object oriented and statically typed, programming language");

        printMaps(languages);
        printMaps(languages);

        // overwriting existing value of a key
        String prevValue = "";
        if (languages.containsKey("Java")) {
            prevValue = languages.put("Java", "Learning Java");
        } else {
            languages.put("Java", "Learning Java");
        }
        printMaps(languages);
        System.out.println("===========================================");
        System.out.println("Prev value : " + prevValue);

        languages.remove("Python");
        printMaps(languages);

    }

    public static void printMaps(Map map) {
        System.out.println(
                "==================================================================================================");

        map.forEach((key, value) -> {
            System.out.println(key + " : " + map.get(key));
        });
        System.out.println(
                "==================================================================================================");

    }
}
