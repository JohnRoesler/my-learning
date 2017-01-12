package src.Section11.GenericsChallenge;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {

    private ArrayList<T> teams;
    private String name;

    public League(String name) {
        this.name = name;
        this.teams = new ArrayList<>();
        System.out.println("League: " + this.name + " was created.");
    }

    public String getName() {
        return name;
    }

    public boolean addTeam(T team){
        for (Team t : this.teams){
            if (t.getName() == team.getName()){
                System.out.println(team.getName() + " is already in the league");
                return false;
            }
        }
        teams.add(team);
        System.out.println(team.getName() + " was added to the league");
        return true;
    }

    public void printStandings(){
        Collections.sort(this.teams);
        System.out.println("\nLeague rankings: ");
        System.out.println("=================================");
        for (Team t : this.teams){
            System.out.println(t.getWon() + "-" + t.getLost() + "-" + t.getTied() + " == " + t.getName() );
        }

    }
}
