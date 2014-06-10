package everything.galaxies;

import everything.CelestialBody;
import everything.CelestialFactory;
import everything.Event;
import everything.Status;
import everything.solar.SolarSystemFactory;
import tools.LogType;

public class Galaxy extends CelestialBody {

    Status myState = Status.NeverExisted;

    @Override
    protected LogType myType() {
        return LogType.Galaxy;
    }

    public void itsAllOver(Event spaceEvent) {
        factory.itsAllOver(spaceEvent);
        myState = Status.Gone;
    }

    @Override
    public CelestialFactory newFactory() {
        return new SolarSystemFactory();
    }

    @Override
    public int lifeSpan() {
        return CosmologicalConstants.randomGalaxyLifespan();
    }
}
