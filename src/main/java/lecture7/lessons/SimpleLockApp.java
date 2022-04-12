package lecture7.lessons;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleLockApp {

  public static void main(String[] args) {

    final Lock lock = new ReentrantLock();

    new Thread(new Runnable() {
      @Override
      public void run() {
        System.err.println("BEFORE-LOCK_1");
        lock.lock();
        System.err.println("GET-LOCK_1");
        try {
          Thread.sleep(8000);
        } catch (InterruptedException exception) {
          exception.printStackTrace();
        } finally {
          System.err.println("END_1");
          lock.unlock();
        }
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        System.err.println("BEFORE-LOCK_1");
        lock.lock();
        System.err.println("GET-LOCK_1");
        try {
          Thread.sleep(8000);
        } catch (InterruptedException exception) {
          exception.printStackTrace();
        } finally {
          System.err.println("END_2");
          lock.unlock();
        }
      }
    }).start();

    new Thread( () -> {
      System.err.println("BEGIN-3");

      try{

        if(lock.tryLock(5, TimeUnit.SECONDS)) {

          try {
            System.err.println("LOCK_SECTION_3");
            try {
              Thread.sleep(13000);
            }catch (InterruptedException e){
              e.printStackTrace();
            }

          }finally {
            lock.unlock();
            System.err.println("END_3");
          }

        }
        else {
          System.err.println("Not needed");
        }

      }catch (InterruptedException exception){
        exception.printStackTrace();

      }

    }).start();

  }
}

  /*  new Thread(new Runnable() {
      @Override
      public void run() {
        System.err.println("T-BEGIN-SECOND");
       *//*
        try {

          if (lock.tryLock(5, TimeUnit.SECONDS)) {
            try {
              System.err.println("T-LOCK_SECTION_SECOND");
              try {
                Thread.sleep(13000);
              }catch (InterruptedException e) {
                e.printStackTrace();
              } finally {
                lock.unlock();
                System.out.println("T-END-SECOND");
              }
              }


        } else {
            System.out.println("Nt needed");
          }
      }
    } catch (InterruptedException exception) {
          exception.printStackTrace();
        })
  }

}*//*
}
*/