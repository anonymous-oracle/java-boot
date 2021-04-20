import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class App {
    public static void main(String[] args) {
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

        placesToVisit.remove(4);
        printList(placesToVisit);

    }

    public static void printList(LinkedList<String> linkedlist) {
        Iterator<String> i = linkedlist.iterator();
        while (i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("==================================");
    }

    private static boolean addInOrder(LinkedList<String> linkedlist, String newCity) {
        ListIterator<String> stringListIterator = linkedlist.listIterator();

        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                // equal, don't add
                System.out.println(newCity + " already exists. Not adding.");
                return false;
            } else if (comparison > 0) {
                // newCity should appear before this one
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparison > 0) {
                // move on to next city

            }

        }
        stringListIterator.add(newCity);
        return true;
    }
}
