package everything;

import tools.LogBuilder;
import tools.LogType;
import tools.StopWatch;
import tools.Waiter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public abstract class CelestialBody extends Thread{

    public final String id = UUID.randomUUID().toString();
    public final StopWatch watch = new StopWatch();
    public Status myState = Status.NeverExisted;
    protected CelestialFactory factory = newFactory();
    protected Map<String, Object> metaData = new HashMap<>();

    final LogBuilder logs = new LogBuilder(myType(), id, this.getClass());

    protected abstract LogType myType();

    @Override
    public void run(){
        logs.logEventFor(Event.Started, metaData);

        watch.start();
        long lifespan = lifeSpan();
        factory.formSome();
        while(watch.check() < lifespan){
            sleepSafely();
        }
        itsAllOver(Event.DestroyedNaturally);
        logs.logEventFor(Event.DestroyedNaturally, metaData);
        myState = Status.Gone;
    }

    protected void sleepSafely() {
        new Waiter().waitAWhile(this);
    }

    public void itsAllOver(Event spaceEvent){
        if(myState == Status.Here){
            myState = Status.Gone;
            logs.logEventFor(spaceEvent, metaData);
            factory.itsAllOver(spaceEvent);
        }
    }

    public abstract CelestialFactory newFactory();
    public abstract int lifeSpan();

}
