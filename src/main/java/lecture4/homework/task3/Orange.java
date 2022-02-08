package lecture4.homework.task3;

public class Orange extends Fruit {

  public static float ORANGE_WEIGHT=1.5f;
  int id;

  public Orange(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Orange{" +
        "id=" + id +
        '}';
  }
}
