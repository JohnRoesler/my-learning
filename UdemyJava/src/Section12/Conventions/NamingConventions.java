package src.Section12.Conventions;

public class NamingConventions {

    /*

    Package
        always lower case
        names must be unique
        use domain name, reversed, as a prefix
        replace invalid characters
            (dash -, replace with underscore_ )
            (must put _ if starting with number, _1234)
            (java keywords must have _ first, _switch)


    Class
        start with capital and all words (e.g. LinkedList, GearBox, TopSong)

    Interface
        capitalize like classes (called CamelCase...haha I get that, because of the humps)
        consider what implementing objects will become (e.g. List, Comparable, Serializable)

    Method
        mixedCase e.g. size, getName, addPlayer
        often verbs
        reflect function performed

    Constant
        separate uppercase words with underscore, e.g. UPPER_CASE, MAX_INT, PI
        declared using 'final' keyword

    Variable
        mixedCase, e.g. league, boxLength, swan, i, x
        meaningful and indicative
        do not use underscores

    Type parameter
        single character, capital letter, e.g. T
        E - Element
        K - Key
        N - Number
        T - Type
        V - Value

     */

}
