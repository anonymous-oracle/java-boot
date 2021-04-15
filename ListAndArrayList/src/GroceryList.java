import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<String>();

    public void addGroceryItem(String item) {
        this.groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.println("You have " + this.groceryList.size() + " items in ");
        for (int i = 0; i < this.groceryList.size(); i++) {
            System.out.println(i + ": " + this.groceryList.get(i));
        }
    }

    public void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println("Grocery item " + (position + 1) + " has been modified");
    }

    public void removeGroceryItem(int position){
        String theItem = groceryList.get(position);
        groceryList.remove(position);
    }
}
