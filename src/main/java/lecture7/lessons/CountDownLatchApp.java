package lecture7.lessons;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchApp {

  public static void main(String[] args) {

    final int THREADS_COUNT = 6;

    final CountDownLatch countDownLatch = new CountDownLatch(THREADS_COUNT);
   // final CountDownLatch countDownLatch = new CountDownLatch(THREADS_COUNT+1);
    System.out.println("Begin");
    for (int i = 0; i < THREADS_COUNT; i++) {
      final int w = i;
      new Thread(() -> {
        try {
          Thread.sleep(200 + w + (int)(500 * Math.random()));
          System.out.println("Thread # : " + w + " - ready");
          countDownLatch.countDown();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();

    }
    try {
      countDownLatch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("End");
  }

}
