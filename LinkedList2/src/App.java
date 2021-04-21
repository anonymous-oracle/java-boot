import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit, "Canberra");
        addInOrder(placesToVisit, "Adelaide");
        addInOrder(placesToVisit, "Darwin");

        printList(placesToVisit);
        addInOrder(placesToVisit, "Alice Springs");
        printList(placesToVisit);

        placesToVisit.remove(4);
        printList(placesToVisit);

        visit(placesToVisit);
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

    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();
        if (cities.isEmpty()) {
            System.out.println("No cities in the itenerary");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
            case 0:
                System.out.println("Holiday (vacation) over");
                quit = true;
                break;
            case 1:
                if (!goingForward) {
                    if (listIterator.hasNext()) {
                        listIterator.next();
                    }
                    goingForward = true;
                }
                if (listIterator.hasNext()) {
                    
                    System.out.println("Now visiting " + listIterator.next());
                } else {
                    System.out.println("Reached the end of the list");
                }
                break;
            case 2:
                if (goingForward) {
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                    }
                    goingForward = false;
                }
                if (listIterator.hasPrevious()) {
                    System.out.println("Now visiting " + listIterator.previous());
                } else {
                    System.out.println("Reached the end of the list");
                }
                break;
            case 3:
                printMenu();
                break;

            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println(
                "0 - to quit\n" + "1 - go to next city\n" + "2 - go to previous city\n" + "3 - print menu options\n");
    }
}
