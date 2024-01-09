import java.util.concurrent.CountDownLatch;

public class DependentService implements Runnable {
    private CountDownLatch latch;
    public DependentService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Connecting to database from thread: " +Thread.currentThread().getName());
        latch.countDown();
        System.out.println("Done.. ");
    }
}
