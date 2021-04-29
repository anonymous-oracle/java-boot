public class Item extends ListItem {
    public Item(Object value) {
        super(value);
        this.nextLink = null;
        this.previousLink = null;
    }

    @Override
    public Object getValue() {
        return this.value;
    }

    @Override
    public ListItem getPreviousLink() {
        return this.previousLink;
    }

    @Override
    public ListItem getNextLink() {
        return this.nextLink;
    }

    @Override
    public void setPreviousLink(ListItem item) {
        this.previousLink = item;
    }

    @Override
    public void setNextLink(ListItem item) {
        this.nextLink = item;

    }

    @Override
    public int compareTo(ListItem item) {
        return ((String) this.value).compareTo((String) item.getValue());
    }

    // @Override
    public String toString() {
        return (String) this.value;
    }
}
