package src.Section10.AbstractChallenge;

/**
 * Created by Z001W4M on 1/6/2017.
 */
public class Node extends ListItem {
    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.nextLink;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.nextLink = item;
        return this.nextLink;
    }

    @Override
    ListItem previous() {
        return this.previousLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.previousLink = item;
        return this.previousLink;
    }

    //returns 0 if values are equal,
    //greater than 0 if value sorts greater than,
    //less than 0 if value sorts less than
    @Override
    int compareTo(ListItem item) {
        if (item != null){
            return ((String) super.getValue()).compareTo((String) item.getValue());
        }else {
        return -1;
        }
    }
}
