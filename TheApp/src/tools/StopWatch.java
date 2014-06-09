package tools;

public class StopWatch {

    private long startTime;

    public long start(){
        this.startTime = System.currentTimeMillis();
        return startTime;
    }

    public long check(){
        long duration = System.currentTimeMillis() - startTime;
        return duration;
    }

    public long reset(){
        long duration = System.currentTimeMillis() - startTime;
        this.startTime = System.currentTimeMillis();
        return duration;
    }
}
