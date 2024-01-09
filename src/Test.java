import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);

        CountDownLatch latch = new CountDownLatch(3);
        service.submit(new DependentService(latch));
        service.submit(new DependentService(latch));
        service.submit(new DependentService(latch));

        latch.await(); // main thread will wait until all the above three threads are initialized

        System.out.println("All dependent services initialized..");
        service.close();
    }
}
