package lecture7.lessons;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceApp {

  public static void main(String[] args) {

    ExecutorService executorService = Executors.newFixedThreadPool(4);
    // Method execute()
    /*for (int i=0;i<10;i++) {

      final int w=i+1;
      executorService.execute(new Runnable() {
        @Override
        public void run() {
          System.out.println(w + " - Begin");
          try {
            Thread.sleep(1000 + (int) (3000 * Math.random()));
          } catch (InterruptedException exception) {
            exception.printStackTrace();
          }
          System.out.println(w + " - End");
        }
      });
    }*/
    executorService.shutdown();

    //Method submit

    ExecutorService service = Executors.newFixedThreadPool(4);

    Future<String> stringFuture = service.submit(new Callable<String>() {
      @Override
      public String call() throws Exception {
        Thread.sleep(2000);
        int i = 10/0;
        return "Java";
      }
    });
    try {
      String result = stringFuture.get();
      System.out.println(result);
    } catch (InterruptedException exception) {
      exception.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    service.shutdown();


  }

}
