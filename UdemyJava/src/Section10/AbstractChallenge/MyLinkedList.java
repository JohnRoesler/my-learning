package src.Section10.AbstractChallenge;

/**
 * Created by Z001W4M on 1/10/2017.
 */
public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null){
            //the list was empty, so this item becomes head of list
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while(currentItem != null){
            int comparison = (currentItem.compareTo(newItem));
            if (comparison < 0){
                //newItem is greater, move right
                if(currentItem.next() != null){
                    currentItem = currentItem.next();
                }else {
                    //there is no next, so insert at end of list
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
            }else if (comparison > 0) {
                //newItem is less, move left
                if (currentItem.previous() != null){
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);
                }else {
                    //the node without a previous is the root
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            }else {
                //equal
                System.out.println(newItem.getValue() + " is already present, not added");
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean removeItem(ListItem deleteItem) {
        if (deleteItem != null){
            System.out.println("Deleting: " + deleteItem.getValue());
        }
        ListItem currentItem = this.root;
        while (currentItem !=null){
            int comparison = currentItem.compareTo(deleteItem);
            if (comparison == 0) {
                //found the item to delete
                if (currentItem == this.root) {
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            }else if (comparison < 0) {
                currentItem = currentItem.next();
            } else {
                //comparison > 0, item greater than one to be deleted
                //so item not in the list
                return false;
            }
        }

        return false;
    }

    @Override
    public void traverse(ListItem root) {
        //not a good idea to do recursion with linked list as
        //this will override the system
        /*if (root != null){
            System.out.println(root.getValue());
            traverse(root.next());
        }*/

        if (root == null){
            System.out.println("The list is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
