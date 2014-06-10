package everything.solar;

import everything.CelestialBody;
import everything.CelestialFactory;
import everything.galaxies.CosmologicalConstants;
import tools.LogType;

public class SolarSystem extends CelestialBody {

    @Override
    public CelestialFactory newFactory() {
        return new PlanetFactory();
    }

    @Override
    public int lifeSpan() {
        return CosmologicalConstants.randomSolarSystemLifespan();
    }



    @Override
    protected LogType myType() {
        return LogType.SolarSystem;
    }
}
