package everything.solar;

import everything.CelestialBody;
import everything.CelestialFactory;
import everything.galaxies.CosmologicalConstants;

public class PlanetFactory extends CelestialFactory {

    private final int planetCount = CosmologicalConstants.randomNumberOfPlanets();

    @Override
    public int numberOfThings() {
        return planetCount;
    }

    @Override
    public CelestialBody createOne() {
        return new Planet();
    }

}
