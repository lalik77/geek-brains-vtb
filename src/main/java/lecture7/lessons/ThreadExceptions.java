package lecture7.lessons;

import java.lang.Thread.UncaughtExceptionHandler;

public class ThreadExceptions {

  public static void main(String[] args) {

    //Not caught exception
   /* try {
      new Thread(new Runnable() {
        @Override
        public void run() {
          int x = 10/0;
        }
      }).start();

    }catch (ArithmeticException e) {
      System.out.println("catched");
      e.printStackTrace();

    }*/

    // Caught exception

    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        int x = 10;
        System.out.println(1);
        x = x /0;
        System.out.println(2);

      }
    });

    //Thread.setDefaultUncaughtExceptionHandler();

    thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
      @Override
      public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        System.out.println("Caught");
      }
    });

    thread.start();

  }

}
