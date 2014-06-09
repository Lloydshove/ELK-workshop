package everything;

import tools.StopWatch;
import tools.Waiter;

import java.util.UUID;

public abstract class CelestialBody extends Thread{

    public final String id = UUID.randomUUID().toString();
    public final StopWatch watch = new StopWatch();
    public Status myState = Status.NeverExisted;
    protected final CelestialFactory factory = newFactory();

    @Override
    public void run(){
        watch.start();
        long lifespan = lifeSpan();
        while(watch.check() < lifespan){
            sleepSafely();
        }
        itsAllOver(Event.DestroyedNaturally);
        myState = Status.Gone;
    }

    protected void sleepSafely() {
        new Waiter().waitAWhile(this);
    }

    public void itsAllOver(Event spaceEvent){
        factory.itsAllOver(spaceEvent);
    }

    public abstract CelestialFactory newFactory();
    public abstract int lifeSpan();

}
