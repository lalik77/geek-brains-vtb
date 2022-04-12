package lecture7.lessons;

import java.util.concurrent.Semaphore;

public class SimpleSemaphoreApp {

  public static void main(String[] args) {

    final Semaphore semaphore = new Semaphore(4);

    Runnable limitedCalls = new Runnable() {
      int count = 0;

      @Override
      public void run() {
        int time = 3 + (int) (Math.random() * 4);
        int num = count++;
        try {
          semaphore.acquire();
          System.out.println("Thread # " + num + " begins for long time action");
          Thread.sleep(time * 1000);
          System.out.println("Thread # " + num + " ends its work");
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          semaphore.release();
        }
      }
    };

    for (int i=0 ;i<10 ; i++) {
      new Thread(limitedCalls).start();
    }
  }
}
