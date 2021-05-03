public class ListItem extends Item {
    protected Object previousLink;
    protected Object nextLink;

    public ListItem(Object value) {
        super(value);
        this.nextLink = null;
        this.previousLink = null;
    }

    @Override
    protected Object getValue() {
        return this.value;
    }

    @Override
    protected Object getPreviousLink() {
        return this.previousLink;
    }

    @Override
    protected Object getNextLink() {
        return this.nextLink;
    }

    @Override
    protected void setPreviousLink(Object item) {
        this.previousLink = item;
    }

    @Override
    protected void setNextLink(Object item) {
        this.nextLink = item;
    }

    @Override
    protected int compareTo(Item item) {
        return (this.value.toString()).compareTo(item.getValue().toString());
    }

    // @Override
    public String toString() {
        return this.value.toString();
    }
}
