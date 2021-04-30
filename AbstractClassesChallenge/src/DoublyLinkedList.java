public class DoublyLinkedList {
    private Item head;
    private Item tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public Object getHead() {
        return this.head;
    }

    public Object getTail() {
        return this.tail;
    }

    public boolean addItem(Object itemName) {
        Item item = new Item(itemName);
        if (this.head.getValue() == null && this.tail.getValue() == null) {
            this.head = item;
            this.tail = item;
            item.setPreviousLink(this.head);
            item.setNextLink(this.tail);
            return true;
        }
        int comparison;
        Item temp = this.head;
        while (temp.getNextLink() != null) {
            comparison = temp.compareTo(item);
            if (comparison >= 0) {
                item.setNextLink(temp);
                item.setPreviousLink(temp.getPreviousLink());
                temp.setPreviousLink(item);
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        if (this.head.getValue() == null && this.tail.getValue() == null) {
            return true;
        }
        return false;
    }
}
