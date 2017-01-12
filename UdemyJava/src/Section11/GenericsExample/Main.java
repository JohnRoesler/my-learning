package src.Section11.GenericsExample;

public class Main {

    public static void main(String[] args) {

        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
//        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
//        adelaideCrows.addPlayer(pat);
//        adelaideCrows.addPlayer(beckham);

        Team<FootballPlayer> vikings = new Team<>("MN Vikings");

        Team<BaseballPlayer> twins = new Team<>("MN Twins");
        twins.addPlayer(pat);

        adelaideCrows.matchResult(vikings,14, 31);

        System.out.println("Rankings");
        System.out.println(adelaideCrows.getName() + ": " + adelaideCrows.ranking());
        System.out.println(vikings.getName() + ": " + vikings.ranking());

        System.out.println(adelaideCrows.compareTo(vikings));

    }



}
