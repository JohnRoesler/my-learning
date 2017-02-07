package src.Section13.Sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        System.out.println("There are " + squares.size() + " squares and " +
                "" + cubes.size() + " cubes");

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() + " elements");

        Set<Integer> intersect = new HashSet<>(squares);
        intersect.retainAll(cubes);
        System.out.println("Intersect contains " + intersect.size() + " elements");

        for (int i : intersect) {
            System.out.println(i + " is the square of " + Math.sqrt(i) + "" +
                    " and the cube of " + Math.cbrt(i));
        }

        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));
        for (String s : words) {
            System.out.println(s);
        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "is", "divine"};
        nature.addAll(Arrays.asList(natureWords));
        divine.addAll(Arrays.asList(divineWords));

        Set<String> nTakeD = new HashSet<>(nature);
        nTakeD.removeAll(divine);
        System.out.println("nature take divine: ");
        printSet(nTakeD);

        Set<String> dTakeN = new HashSet<>(divine);
        dTakeN.removeAll(nature);
        System.out.println("divine take nature: ");
        printSet(dTakeN);

        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectTest = new HashSet<>(nature);
        intersectTest.retainAll(divine);

        System.out.println("Symetric difference: ");
        unionTest.removeAll(intersectTest);
        printSet(unionTest);
        System.out.println("Intersect: ");
        printSet(intersectTest);

        if (nature.containsAll(divine)){
            System.out.println("Divine is a subset of nature");
        }
        if (nature.containsAll(intersectTest)){
            System.out.println("Intersect is a subset of nature");
        }
        if (divine.containsAll(intersectTest)){
            System.out.println("Divine is a subset of nature");
        }
    }

    private static void printSet(Set<String> set){
        System.out.print("\t");
        for (String s : set){
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
