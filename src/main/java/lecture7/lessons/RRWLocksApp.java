package lecture7.lessons;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RRWLocksApp {

  public static void main(String[] args) {

    ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();

    //Reading
    new Thread( () -> {

      rw1.readLock().lock();

      try {
        System.out.println("READING-start-a");
        Thread.sleep(3000);

      }catch (InterruptedException e) {
        e.printStackTrace();
      }finally {
        System.out.println("READING-end-a");
        rw1.readLock().unlock();
      }

    }).start();


    new Thread( () -> {
      try {
        rw1.readLock().lock();
        System.out.println("READING-start-b");
        Thread.sleep(5000);

      }catch (InterruptedException e) {
        e.printStackTrace();
      }finally {
        System.out.println("READING-end-b");
        rw1.readLock().unlock();
      }

    }).start();

    new Thread( () -> {

      try {
        Thread.sleep(1000);
      }catch (InterruptedException e) {
        e.printStackTrace();
      }
      rw1.readLock().lock();

      try {
        System.out.println("READING-start-c");
        Thread.sleep(3000);

      }catch (InterruptedException e) {
        e.printStackTrace();
      }finally {
        System.out.println("READING-end-c");
        rw1.readLock().unlock();
      }

    }).start();

    //Writing
    new Thread( () -> {

      rw1.writeLock().lock();

      try {
        System.out.println("Writing-start-a");
        Thread.sleep(3000);

      }catch (InterruptedException e) {
        e.printStackTrace();
      }finally {
        System.out.println("Writing-end-a");
        rw1.writeLock().unlock();
      }

    }).start();

    new Thread( () -> {

      rw1.writeLock().lock();

      try {
        System.out.println("Writing-start-b");
        Thread.sleep(3000);

      }catch (InterruptedException e) {
        e.printStackTrace();
      }finally {
        System.out.println("Writing-end-b");
        rw1.writeLock().unlock();
      }

    }).start();
  }

}
