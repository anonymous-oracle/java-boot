public class DoublyLinkedList {
    private Object head;
    private Object tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public DoublyLinkedList(String elementString, String separator) {
        this();
        this.addFromString(elementString, separator);
    }

    public DoublyLinkedList(String elementString) {
        this();
        this.addFromString(elementString, " ");
    }

    public Object getHead() {
        return this.head;
    }

    public Object getTail() {
        return this.tail;
    }

    private boolean firstPush(ListItem item) {
        if (this.head == null && this.tail == null) {
            this.head = item;
            this.tail = item;
            return true;
        }
        return false;
    }

    public boolean pushOrdered(Object itemName) {
        ListItem item = new ListItem(itemName);
        if (this.firstPush(item)) {
            return true;
        }
        int comparison;
        this.push(item);
        ListItem temp = (ListItem) ((ListItem) this.tail).getPreviousLink();
        while (temp != null) {
            comparison = temp.compareTo(item);
            if (comparison > 0) {
                this.tail = temp;
                item.setNextLink(temp);
                item.setPreviousLink(temp.getPreviousLink());
                temp.setPreviousLink(item);
                temp.setNextLink(null);
            } else {
                return true;
            }
            temp = (ListItem) ((ListItem) this.tail).getPreviousLink();
        }
        return false;
    }

    public ListItem pop() {
        ListItem pop = (ListItem) this.tail;
        this.tail = ((ListItem) this.tail).getPreviousLink();
        return pop;
    }

    public ListItem popFront() {
        ListItem pop = (ListItem) this.head;
        this.head = ((ListItem) this.head).getNextLink();
        return pop;
    }

    public boolean push(Object itemName) {
        ListItem item = new ListItem(itemName);
        if (this.firstPush(item)) {
            return true;
        }
        item.setPreviousLink((ListItem) this.tail);
        ((ListItem) this.tail).setNextLink(item);
        this.tail = item;
        return true;
    }

    public ListItem remove(Object itemName) {
        Item temp = (Item) this.head;
        ListItem item = new ListItem(itemName);
        while (temp != null) {
            if (temp.compareTo(item) == 0) {
                ((ListItem) temp.getPreviousLink()).setNextLink(temp.getNextLink());
                ((ListItem) temp.getNextLink()).setPreviousLink(temp.getPreviousLink());
                return (ListItem) temp;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        if (((ListItem) this.head).getValue() == null && ((ListItem) this.tail).getValue() == null) {
            return true;
        }
        return false;
    }

    public boolean addFromString(String elementString, String separator) {
        if (elementString.isEmpty()) {
            return false;
        }
        String[] array = elementString.split(separator);
        for (var i = 0; i < array.length; i++) {
            this.pushOrdered(array[i]);
        }
        return true;
    }

    public String toString() {
        String stringRep = "";
        if(this.head==null){
            return "";
        }
        Item temp = (Item) this.head;
        
        while (temp.getNextLink() != null) {
            stringRep += temp.toString() + ", ";
            temp = (Item) temp.getNextLink();
        }
        stringRep += temp.toString();
        return stringRep;
    }
}
