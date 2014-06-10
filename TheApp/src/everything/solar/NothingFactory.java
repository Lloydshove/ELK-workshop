package everything.solar;

import everything.CelestialBody;
import everything.CelestialFactory;


public class NothingFactory extends CelestialFactory {
    @Override
    public int numberOfThings() {
        return 0;
    }

    @Override
    public CelestialBody createOne() {
        throw new UnsupportedOperationException();
    }
}
