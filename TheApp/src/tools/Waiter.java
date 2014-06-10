package tools;

import everything.galaxies.CosmologicalConstants;

public class Waiter {

    public void waitAWhile(Thread theThread) {
        try {
            theThread.sleep(CosmologicalConstants.randomDelay());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
