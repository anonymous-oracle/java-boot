public class DoublyLinkedList {
    private ListItem head;
    private ListItem tail;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public ListItem getHead(){
        return this.head;
    }

    public ListItem getTail(){
        return this.tail;
    }

    public boolean addItem(ListItem item){
        if(this.head==null && this.tail==null){
            this.head = item;
            this.tail = item;
            item.setPreviousLink(null);
            item.setNextLink(null);
            return true;
        }
        ListItem temp = this.head;
        
    }
}
