/**
 * Created by julia on 12.12.2016.
 * @author Julia Savicheva
 */
public class Main {
    static RandomCounter counter = new RandomCounter();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    counter.incrementTime();
                    synchronized(counter) {
                        counter.notifyAll();
                    }
                }
            }
        });
        t1.start();
        CounterThread t2 = new CounterThread(counter, 5);
        t2.start();
    }
}
