/**
 * Created by julia on 08.12.2016.
 * @author Julia Savicheva
 */
public class CounterThread extends Thread implements Runnable {
    int timeInterval;
    RandomCounter counter;

    /**
     * @param counter generetes random numbers from 0 to 99 and write them in set
     * @param interval time, how often write statistic
     */
    public CounterThread(RandomCounter counter, int interval) {
        this.counter = counter;
        this.timeInterval = interval;
    }

    /**
     * Overrided run() method
     */
    @Override
    public void run() {
        while (!this.isInterrupted()) {
            synchronized(counter) {
                try {
                    counter.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            counter.generateRandomNumber();
            if (counter.getTime() % timeInterval == 0) {
                System.out.println(counter.getCount() + " numbers generated");
            }
        }
    }
}
