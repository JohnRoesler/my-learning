package src.Generics.Challenge;

public class Main {

    public static void main(String[] args) {
        Team<Volleyball> ScaredHitless = new Team<>("Scared Hitless");
        Team<Volleyball> OneTwo = new Team<>("One Two");
        Team<Volleyball> TBD = new Team<>("TBD");
        Team<Volleyball> NetResults = new Team<>("Net Results");
        Team<Volleyball> Jimmys = new Team<>("Jimmy's");

        League<Team<Volleyball>> maplewood = new League<>("Maplewood Co-ed");

        maplewood.addTeam(ScaredHitless);
        maplewood.addTeam(OneTwo);
        maplewood.addTeam(TBD);
        maplewood.addTeam(NetResults);
        maplewood.addTeam(Jimmys);

        ScaredHitless.matchResult(OneTwo,25,18);
        ScaredHitless.matchResult(OneTwo,27,27);
        ScaredHitless.matchResult(OneTwo,12,25);
        ScaredHitless.matchResult(TBD,25,16);
        TBD.matchResult(OneTwo,25,23);
        Jimmys.matchResult(NetResults,25,10);
        Jimmys.matchResult(NetResults,25,25);
        Jimmys.matchResult(NetResults,25,25);

        maplewood.printStandings();
        

// won't work now as correctly created League<Team<Sport>>!!!
//        Team<Football> vikings = new Team<>("Vikings");
//        maplewood.addTeam(vikings);

    }
}
