package everything.solar;

import everything.CelestialBody;
import everything.CelestialFactory;
import everything.galaxies.CosmologicalConstants;

public class Planet extends CelestialBody {

    private final boolean hasSentientLife;

    public Planet(){
        this.hasSentientLife = CosmologicalConstants.hasSentientLife();
    }

    @Override
    public CelestialFactory newFactory() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lifeSpan() {
        return CosmologicalConstants.randomPlanetLifespan();
    }
}
