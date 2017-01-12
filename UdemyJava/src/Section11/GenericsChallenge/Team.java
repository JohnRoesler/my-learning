package src.Section11.GenericsChallenge;

public class Team<T extends Sport> implements  Comparable<Team<T>> {

    private String name;
    private int played = 0;
    private int won = 0;
    private int lost = 0;
    private int tied = 0;

    public Team(String name) {
        this.name = name;
        System.out.println("Team: " + this.name + " was created.");
    }


    public void matchResult(Team<T> opponent, int ourScore, int theirScore){
        String message;
        if (ourScore > theirScore){
            won ++;
            message = " beat ";
        } else if (ourScore < theirScore) {
            lost++;
            message = " lost to ";
        } else {
            tied++;
            message = " tied with ";
        }
        played ++;
        if (opponent != null){
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null,theirScore,ourScore);
        }
    }

    public String getName() {
        return name;
    }

    public int getWon() {
        return won;
    }

    public int getLost() {
        return lost;
    }

    public int getTied() {
        return tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.won > team.won){
            return -1;
        } else if (this.won < this.won){
            return 1;
        } else {
            return 0;
        }
    }
}
