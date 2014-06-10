package everything.solar;

import everything.CelestialBody;
import everything.CelestialFactory;
import everything.galaxies.CosmologicalConstants;
import tools.LogType;

public class Planet extends CelestialBody {


    public Planet(){
        this.metaData.put("HasSentientLife", CosmologicalConstants.hasSentientLife());
        this.metaData.put("InventsBigBrotherTvShow", !CosmologicalConstants.hasSentientLife());
    }

    @Override
    public CelestialFactory newFactory() {
        return new NothingFactory();
    }

    @Override
    public int lifeSpan() {
        return CosmologicalConstants.randomPlanetLifespan();
    }

    @Override
    protected LogType myType() {
        return LogType.Planet;
    }
}
