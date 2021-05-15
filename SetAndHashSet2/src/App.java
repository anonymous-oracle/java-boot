import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<Integer>();
        Set<Integer> cubes = new HashSet<Integer>();

        for (int i = 0; i < 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        System.out.println("There are " + squares.size() + " and " + cubes.size() + " cubes.");
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() + " elements.");

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection contains " + intersection.size() + " elements.");
        for (var i : intersection) {
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and cube of " + Math.cbrt(i));
        }

        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayOfWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayOfWords));
        System.out.println("Words:");
        for (var word : words) {
            System.out.println("\t" + word);
        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = { "all", "nature", "is", "but", "art", "unknown", "to", "thee" };
        nature.addAll(Arrays.asList(natureWords));
        String[] divineWords = { "to", "err", "is", "human", "to", "forgive", "divine" };
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("nature - divine:");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("divine - nature:");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        Set<String> unionTest = new HashSet<String>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);
        
        System.out.println("Symmetric difference: ");
        unionTest.removeAll(intersectionTest); // modifies inplace
        printSet(unionTest); 
    
        if(nature.containsAll(divine)){
            System.out.println("divine is a subset of nature");
        }

        if(nature.containsAll(intersectionTest)){
            System.out.println("intersection is subset of nature");
        }

        if(divine.containsAll(intersectionTest)){
            System.out.println("divine is a subset of nature");
        }
        
    }

    private static void printSet(Set<String> set) {
        System.out.print("\t");
        set.forEach((e) -> {
            System.out.print(e + " ");
        });
        System.out.println();
    }


}
