package tools;

public class Waiter {

    public void waitAWhile(Thread theThread) {
        try {
            theThread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
