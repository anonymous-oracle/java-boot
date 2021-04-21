import java.util.Iterator;
import java.util.LinkedList;

public class Demo {
    private static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        placesToVisit.add("Sydney");
        placesToVisit.add("Melbourne");
        placesToVisit.add("Brisbane");
        placesToVisit.add("Perth");
        placesToVisit.add("Canberra");
        placesToVisit.add("Adelaide");
        placesToVisit.add("Darwin");

        printList(placesToVisit);
        placesToVisit.add(1, "Alice Springs");
        printList(placesToVisit);

    }

    public static void printList(LinkedList<String> linkedlist) {
        Iterator<String> i = linkedlist.iterator();
        while (i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("==================================");
    }
}