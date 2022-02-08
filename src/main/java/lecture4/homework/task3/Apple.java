package lecture4.homework.task3;

public class Apple extends Fruit {

  public static float APPLE_WEIGHT=1.0f;
  int id;

  public Apple(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Apple{" +
        "id=" + id +
        '}';
  }
}
