package src.Section13.Maps;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        if (languages.containsKey("Java")){
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "a compiled high level, object-oriented, platform" +
                    " independent language");
            System.out.println("Java added successfully");
        }

        languages.put("Python", "an interpreted, object oriented, high-level programming" +
                " language with dynamic semantics" );
        System.out.println(languages.put("Algol", "an algorithmic language"));
        System.out.println(languages.put("Lisp", "Therein lies maddness"));

        if (languages.containsKey("Java")){
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "this course is about java");
        }

        System.out.println("=============================================");

//        languages.remove("Lisp");
        if (languages.remove("Algol", "an algorithmic language")){
            System.out.println("Algol removed");
        } else {
            System.out.println("Algol not removed");
        }

//        The replace method returns the previous value if the Key is found
        if (languages.replace("Lisp", languages.get("Lisp"), "a functional programming language")){
            System.out.println("Lisp replaced");
        } else {
            System.out.println("Lisp not replaced");
        }
        System.out.println(languages.replace("Scala", "this will not be added"));

        for (String key:languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }

    }



}
