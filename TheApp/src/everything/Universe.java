package everything;

import everything.galaxies.CosmologicalConstants;
import everything.galaxies.GalaxyFactory;
import org.apache.log4j.PropertyConfigurator;
import tools.LogBuilder;
import tools.LogType;
import tools.Waiter;

import java.util.HashMap;
import java.util.Map;

import static everything.Event.DestroyedByTheDaleks;
import static everything.Event.Started;
import static tools.LogType.Universe;

public class Universe extends CelestialBody {

    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    Map<String, Object> emptyMap = new HashMap<>();

    public static void main(String[] args) {
        new Universe().start();
    }

    @Override
    protected LogType myType() {
        return LogType.Universe;
    }

    @Override
    public void run() {
        final LogBuilder logs = new LogBuilder(myType(), id, this.getClass());


        while(true){
            watch.start();

            factory = newFactory();
            myState = Status.Here;
            logs.logEventFor(Started, emptyMap);
            long lifespan = lifeSpan();

            factory.formSome();
            while(lifespan < watch.check()){
                new Waiter().waitAWhile(this);
            }

            logs.logEventFor(DestroyedByTheDaleks, emptyMap);
            factory.itsAllOver(DestroyedByTheDaleks);
        }
    }


    @Override
    public CelestialFactory newFactory() {
        return new GalaxyFactory();
    }

    @Override
    public int lifeSpan() {
        return CosmologicalConstants.randomUniverseLifespan();
    }


}
