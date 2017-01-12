package src.Section10.AbstractChallenge;

/**
 * Created by Z001W4M on 1/6/2017.
 */
public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root);
}
