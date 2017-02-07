package src.Section13.Sets;

public class Planet extends HeavenlyBody {
    public Planet(String name, double orbitalPeriod) {
        super(name, BodyTypes.PLANET, orbitalPeriod);
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        if (satellite.getKey().getBodyType() == BodyTypes.MOON){
            return super.addSatellite(satellite);
        } else {
            return false;
        }
    }
}
