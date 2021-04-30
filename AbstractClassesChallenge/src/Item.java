public class Item extends ListItem {
    public Item(Object value) {
        super(value);
    }

    @Override
    protected Object getValue() {
        return this.value;
    }

    @Override
    protected ListItem getPreviousLink() {
        return this.previousLink;
    }

    @Override
    protected ListItem getNextLink() {
        return this.nextLink;
    }

    @Override
    protected void setPreviousLink(ListItem item) {
        this.previousLink = item;
    }

    @Override
    protected void setNextLink(ListItem item) {
        this.nextLink = item;

    }

    @Override
    protected int compareTo(ListItem item) {
        return (this.value.toString()).compareTo(item.getValue().toString());
    }

    // @Override
    public String toString() {
        return (String) this.value;
    }
}
