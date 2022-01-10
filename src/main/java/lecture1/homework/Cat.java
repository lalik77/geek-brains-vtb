package lecture1.homework;

public class Cat extends Animal
 {
  private final String name;
  private static final double runLimit = 200.0;
  private double distance;

  public Cat(String name) {
    this.name = name;
    this.distance=0;
  }

  @Override
  void run(double dist) {
    if (dist > runLimit) {
      print(this.name + " - " + AnimalType.CAT +
          ".А " + AnimalType.CATS + " не могут пробежать больше чем " +
          runLimit + " метров!");
    } else {
      this.distance = dist;
      print(this.name + " - " + AnimalType.CAT + "." +
          this.name + " пробежал " + distance + " м.");
    }
  }

  @Override
  void swim(double dist) {
    print(this.name + " - " + AnimalType.CAT +
        ".А " + AnimalType.CATS + " не умеют плавать!");
  }

   @Override
   final void print(String message) {
     setMessage(message);
     System.out.println(message);
   }
}
