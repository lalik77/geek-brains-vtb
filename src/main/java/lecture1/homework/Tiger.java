package lecture1.homework;

public class Tiger extends Animal {

  private final String name;
  private static final double runLimit = 2000.0;
  private static final double swimLimit = 12.0;
  private double distance;

  public Tiger(String name) {
    this.name = name;
    this.distance=0;
  }

  @Override
  void run(double dist) {
    if (dist > runLimit) {
      print(this.name + " - " + AnimalType.TIGER +
          ".А " + AnimalType.TIGERS + " не могут пробежать больше чем " +
          runLimit + " метров!");
    }else {
      this.distance = dist;
      print(this.name + " - " + AnimalType.TIGER + "." +
          this.name + " пробежал " + distance + " м.");
    }
  }

  @Override
  void swim(double dist) {
    if (dist > swimLimit) {
      print(this.name + " - " + AnimalType.TIGER + ".А " + AnimalType.TIGERS +
          " не могут проплыть больше чем " + swimLimit + " метров!");
    } else {
      this.distance = dist;
      print(this.name + " - " + AnimalType.TIGER + "." + this.name +
          " проплыл " + distance + " м.");
    }
  }

  @Override
  final void print(String message) {
    setMessage(message);
    System.out.println(message);
  }
}
