package lecture7.given;

public class Car implements Runnable {

  private static int CARS_COUNT;
  private Race race;
  private int speed;
  private String name;

  static {
    CARS_COUNT = 0;
  }

  public Car(Race race, int speed) {
    this.race = race;
    this.speed = speed;
    CARS_COUNT++;
    this.name = "Участник #" + CARS_COUNT;
  }

  public String getName() {
    return name;
  }

  public int getSpeed() {
    return speed;
  }

  @Override
  public void run() {

    try {
      System.out.println(this.name + " готовятся");
      Thread.sleep(500 + (int) (Math.random() * 800));
      System.out.println(this.name + " готов");
    } catch (InterruptedException exception) {
      exception.printStackTrace();
    }
    for (int i = 0; i < race.getStages().size(); i++) {
      race.getStages().get(i).go(this);
    }
  }
}
