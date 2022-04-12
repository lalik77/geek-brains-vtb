package lecture7.homework;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import lecture7.lessons.CyclicBarrierApp;

public class MainApp {

  public static final int CARS_COUNT = 4;

  public static void main(String[] args) {
    System.out.println("Важное объявление >>> Подготовка !!!");
    CyclicBarrier barrier = new CyclicBarrier(CARS_COUNT + 1);
    Race race = new Race(
        new Road(60),
        new Tunnel(),
        new Road(40)
    );
    Car[] cars = new Car[CARS_COUNT];

    for(int i= 0; i < cars.length; i++){
      cars[i] = new Car(race,20+(int)(Math.random()*10),barrier);
    }

    for (int i = 0 ; i < cars.length; i++) {
      new Thread(cars[i]).start();
    }
    try {
      barrier.await();
      System.out.println("Важное объявление >>> Гонка началась!!!");
      barrier.await();
      barrier.await();
      System.out.println("Важное объявление >>> Гонка закончилась!!!");
    } catch (InterruptedException exception) {
      exception.printStackTrace();
    } catch (BrokenBarrierException e) {
      e.printStackTrace();
    }




  }

}