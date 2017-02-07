package src.Section13.Sets;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;


    public enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(String name, BodyTypes bodyType, double orbitalPeriod) {
        this.key = new Key(name,bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody satellite){
        return this.satellites.add(satellite);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(satellites);
    }

    public static Key makeKey(String name, BodyTypes bodyType){
        return new Key(name,bodyType);
    }

    @Override
//    http://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#equals-java.lang.Object-
    public final boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o instanceof HeavenlyBody){
            HeavenlyBody obj = (HeavenlyBody) o;
            return this.key.equals(obj.getKey());
        }
        return false;

    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return this.key.getName() + ": " + this.key.getBodyType() + " ," + this.orbitalPeriod;
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public boolean equals(Object o) {
            Key key = (Key) o;
            if (this.name.equals(key.getName())){
                return this.bodyType == key.getBodyType();
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public String toString() {
            return this.getName() + ": " + this.getBodyType();
        }
    }
}
