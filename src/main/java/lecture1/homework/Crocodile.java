package lecture1.homework;

public class Crocodile extends Animal {

  private final String name;
  private static final double swimLimit = 300.0;
  private double distance;

  public Crocodile(String name) {
    this.name = name;
    this.distance = 0;
  }

  @Override
  void run(double dist) {
    print(this.name + " - " + AnimalType.CROCODILE +
        ".А " + AnimalType.CROCODILES + " не умеют бегать!");
  }

  @Override
  void swim(double dist) {
    if (dist > swimLimit) {
      print(this.name + " - " + AnimalType.CROCODILE +
          ".А " + AnimalType.CROCODILE + "не может проплыть больше чем " +
          swimLimit + " метров");
    } else {
      this.distance = dist;
      print(this.name + " - " + AnimalType.CROCODILE + "." + this.name +
          " пробежал " + distance + " м.");
    }
  }

  @Override
  final void print(String message) {
    setMessage(message);
    System.out.println(message);
  }
}
