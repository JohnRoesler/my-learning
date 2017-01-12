package src.Section8.Composition;

/**
 * Created by john on 12/11/16.
 */
public class Room {

    private String name;
    private String roomType;
    private Couch newCouch;
    private TV newTV;
    private Lights newLights;


    public Room(String name, String roomType, Couch newCouch, TV newTV, Lights newLights) {
        this.name = name;
        this.roomType = roomType;
        this.newCouch = newCouch;
        this.newTV = newTV;
        this.newLights = newLights;
    }

    public void listItemsInRoom(){
        System.out.println(this.name + " " + this.roomType + " " + this.newCouch + " " + this.newTV + " " + this.newLights);
    }
}
