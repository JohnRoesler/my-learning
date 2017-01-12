package src.Section10.AbstractChallenge;

/**
 * Created by Z001W4M on 1/6/2017.
 */
public abstract class ListItem {

    protected ListItem nextLink = null;
    protected ListItem previousLink = null;

    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);

    //returns 0 if values are ListItem values are equal,
    //greater than 0 if value sorts greater than,
    //less than 0 if value sorts less than
    abstract int compareTo(ListItem item);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
