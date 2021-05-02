public abstract class Item {

    protected Object value;

    public Item(Object value) {
        this.value = value;
    }

    protected abstract Object getValue();

    protected abstract void setPreviousLink(Object item);

    protected abstract void setNextLink(Object item);

    protected abstract Object getNextLink();

    protected abstract Object getPreviousLink();

    protected abstract int compareTo(Item item);
    // public abstract String toString();

}
