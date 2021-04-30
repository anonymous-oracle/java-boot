public abstract class ListItem {
    protected ListItem previousLink;
    protected ListItem nextLink;
    protected Object value;

    public ListItem(Object value){
        this.value = value;
        this.nextLink = null;
        this.previousLink = null;
    }

    protected abstract Object getValue();
    protected abstract void setPreviousLink(ListItem item);
    protected abstract void setNextLink(ListItem item);
    protected abstract ListItem getNextLink();
    protected abstract ListItem getPreviousLink();
    protected abstract int compareTo(ListItem item);
    // public abstract String toString();

}
