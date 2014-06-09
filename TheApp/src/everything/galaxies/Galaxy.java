package everything.galaxies;

import everything.CelestialBody;
import everything.CelestialFactory;
import everything.Event;
import everything.Status;

public class Galaxy extends CelestialBody {

    Status myState = Status.NeverExisted;

    public void itsAllOver(Event spaceEvent) {
        factory.itsAllOver(spaceEvent);
        myState = Status.Gone;
    }

    @Override
    public CelestialFactory newFactory() {
        return new GalaxyFactory();
    }

    @Override
    public int lifeSpan() {
        return CosmologicalConstants.randomGalaxyLifespan();
    }
}
