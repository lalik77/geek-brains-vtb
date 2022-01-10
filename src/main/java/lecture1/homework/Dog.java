package lecture1.homework;

public class Dog extends Animal {

  private final String name;
  private static final double runLimit = 500.0;
  private static final double swimLimit = 10.0;
  private double distance;

  public Dog(String name) {
    this.name = name;
    this.distance = 0;
  }

  @Override
  void run(double dist) {
    if (dist > runLimit) {
      print(this.name + " - " + AnimalType.DOG +
          ".А " + AnimalType.DOGS + " не могут пробежать больше чем " +
          runLimit + " метров!");
    } else {
      this.distance = dist;
      print(this.name + " - " + AnimalType.DOG + "." +
          this.name + " пробежал " + distance + " м.");
    }
  }

  @Override
  void swim(double dist) {
    if (dist > swimLimit) {
      print(this.name + " - " + AnimalType.DOG + ".А " + AnimalType.DOGS +
          " не могут проплыть больше чем " + swimLimit + " метров!");
    } else {
      this.distance = dist;
      print(this.name + " - " + AnimalType.DOG + "." + this.name +
          " проплыл " + distance + " м.");
    }
  }

  @Override
  final void print(String message) {
    setMessage(message);
    System.out.println(message);
  }
}
