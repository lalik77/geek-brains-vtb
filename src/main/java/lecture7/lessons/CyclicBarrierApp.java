package lecture7.lessons;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierApp {

  public static void main(String[] args) {

    final int THREADS_COUNT = 5;
    CyclicBarrier cyclicBarrier = new CyclicBarrier(THREADS_COUNT);
    for (int i = 0; i < THREADS_COUNT; i++) {
      int w = i;
      new Thread(() -> {

        try {
          System.out.println("Getting ready" + w);
          Thread.sleep(2000 + (int) (Math.random() * 10));
          System.out.println("Ready " + w);
          cyclicBarrier.await();
          System.out.println("Start " + w);
        } catch (InterruptedException | BrokenBarrierException exception) {
          exception.printStackTrace();
        }


      }).start();
    }

  }

}
