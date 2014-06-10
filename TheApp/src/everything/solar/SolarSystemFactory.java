package everything.solar;

import everything.CelestialBody;
import everything.CelestialFactory;
import everything.galaxies.CosmologicalConstants;

public class SolarSystemFactory extends CelestialFactory {

    private final int solarSystemCount = CosmologicalConstants.randomNumberOfSolarSystems();

    @Override
    public int numberOfThings() {
        return solarSystemCount;
    }

    @Override
    public CelestialBody createOne() {
        return new SolarSystem();
    }
}
