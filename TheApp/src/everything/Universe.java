package everything;

import everything.galaxies.CosmologicalConstants;
import everything.galaxies.GalaxyFactory;
import org.apache.log4j.PropertyConfigurator;
import tools.LogBuilder;
import tools.Waiter;

import static everything.Event.DestroyedByTheDaleks;
import static everything.Event.Started;
import static tools.LogType.Universe;

public class Universe extends CelestialBody {

    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    public static void main(String[] args) {
        new Universe().start();
    }

    @Override
    public void run() {
        myState = Status.Here;
        LogBuilder logs = new LogBuilder(Universe, id, this.getClass());

        logs.logEventFor(Started);
        int lifespan = lifeSpan();
        while(lifespan < watch.check()){
            factory.formSome();
            new Waiter().waitAWhile(this);
        }

        logs.logEventFor(DestroyedByTheDaleks);
        factory.itsAllOver(DestroyedByTheDaleks);
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
