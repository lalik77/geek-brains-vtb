package lecture7.lessons;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class AnotherExecutorServiceExampleApp {

  public static void main(String[] args) throws InterruptedException {

    // Example with new callable
   /* ExecutorService service1 = Executors.newFixedThreadPool(2);
    Future<String> future = service1.submit(new Callable<String>() {
      @Override
      public String call() throws Exception {
        Thread.sleep(2000);
        //int x= 10/0;
        return "Java";
      }
    });

    try {
      System.out.println(future.get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    System.out.println("END");
    service1.shutdown();*/

    // Example with new ThreadFactory

    ExecutorService service = Executors.newFixedThreadPool(4, new ThreadFactory() {
      @Override
      public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setPriority(10);
        t.setName("ABC");
        System.out.println("created");
        return t;
      }
    });

    service.execute(() -> System.out.println(1));
    Thread.sleep(2000);
    service.execute(() -> System.out.println(2));
    Thread.sleep(2000);
    service.execute(() -> System.out.println(3));
    Thread.sleep(2000);
    service.execute(() -> System.out.println(4));
    Thread.sleep(2000);
    service.execute(() -> System.out.println(5));
    Thread.sleep(2000);
    service.execute(() -> System.out.println(6));
    Thread.sleep(2000);

    service.shutdown();



  }

}
