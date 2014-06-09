package everything;

import java.util.ArrayList;
import java.util.List;

public abstract class CelestialFactory {

    List<CelestialBody> things = new ArrayList<>();

    public void formSome(){
        for(int i = 0; i < numberOfThings(); i ++){
            CelestialBody thing = createOne();
            thing.start();
        }
    }

    public void itsAllOver(Event spaceEvent) {
        for(CelestialBody thing : things){
            thing.itsAllOver(spaceEvent);
        }
    }

    public abstract int numberOfThings();
    public abstract CelestialBody createOne();

}
