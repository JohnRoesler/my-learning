package src.Section8.Polymorphism;

/**
 * Created by Z001W4M on 12/13/2016.
 */
public class Main {

    public static void main(String[] args) {

        for (int x = 1; x < 11; x++){
            Car car = randomCar();
            System.out.println("Car #" + x + " : " + car.getName());
            car.accelerate(60);
        }

        /*for (int x = 1; x < 11; x++){
            Movie movie = randomMovie();
            System.out.println("Movie #" + x +
                    " : " + movie.getName() + "\n" +
                    "Plot: " + movie.plot() + "\n");
        }*/

    }

    public static Car randomCar() {
        int randNum = (int) (Math.random() * 4) + 1;
        System.out.println("Random number generated was " + randNum);
        switch (randNum) {
            case 1:
                return new BMW(6, "z4");
            case 2:
                return new Honda(4, "Civic");
            case 3:
                return new Ford(8, "F150");
            case 4:
                return new GMC(8, "Sierra");
            default:
                return null;
        }
    }
/*    public static Movie randomMovie(){
        int randNum = (int) (Math.random() * 5) + 1;
        System.out.println("Random number generated was " + randNum);
        switch (randNum){
            case 1: return new Jaws();
            case 2: return new IndependenceDay();
            case 3: return new MazeRunner();
            case 4: return new StarWars();
            case 5: return new forgettableMovie();
            default: return null;
        }
    }*/

}

class Movie {
    private String name;
    public Movie(String name){
        this.name = name;
    }
    public  String plot() {
        return "No plot here";
    }

    public String getName() {
        return name;
    }
}

class Jaws extends Movie{
    public Jaws(){
        super("Jaws");
    }
    @Override
    public String plot(){
        return "A shark eats lots of people";
    }
}

class IndependenceDay extends Movie{
    public IndependenceDay() {
        super("Independence Day");
    }

    @Override
    public String plot() {
        return "Aliens attempt to take over planet earth";
    }
}

class MazeRunner extends Movie{
    public MazeRunner() {
        super("Maze Runner");
    }

    @Override
    public String plot() {
        return "Kids try and escape a maze";
    }
}

class StarWars extends Movie{
    public StarWars() {
        super("Star Wars");
    }

    @Override
    public String plot() {
        return "Imperial forces try to take over the universe";
    }
}

class forgettableMovie extends Movie{
    public forgettableMovie() {
        super("Forgettable");
    }
    //no plot method here
}


