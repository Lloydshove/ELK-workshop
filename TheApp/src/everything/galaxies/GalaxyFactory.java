package everything.galaxies;

import everything.CelestialBody;
import everything.CelestialFactory;

public class GalaxyFactory extends CelestialFactory {

    private final int galaxyCount = CosmologicalConstants.randomNumberOfGalaxies();

    @Override
    public int numberOfThings() {
        return galaxyCount;
    }

    @Override
    public CelestialBody createOne() {
        return new Galaxy();
    }
}
