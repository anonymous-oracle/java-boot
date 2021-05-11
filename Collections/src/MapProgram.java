import java.util.Map;

public class MapProgram {
    private static void main(String[] args) {
        Map<String, String> languages = new java.util.HashMap<>(); // Map is a base collection and HashMap is
                                                                   // implemented from Map
        languages.put("Java", "A compiled high level, object oriented, platform independent programming language");
        languages.put("Python", "an interpreted high level object oriented programming language");
        languages.put("C", "A compiled high level, modular, programming language");
        languages.put("C++", "A compiled high level, object oriented and statically typed, programming language");
        languages.put("Golang", "A compiled high level, object oriented and statically typed, programming language");

        for (String string : languages.keySet()) {
            System.out.println(string+": "+languages.get(string));
        }
    }
}
