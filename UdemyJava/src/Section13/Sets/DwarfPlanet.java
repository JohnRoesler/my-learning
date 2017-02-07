package src.Section13.Sets;

public class DwarfPlanet extends HeavenlyBody{

    public DwarfPlanet(String name, double orbitalPeriod) {
        super(name, BodyTypes.DWARF_PLANET, orbitalPeriod);
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
