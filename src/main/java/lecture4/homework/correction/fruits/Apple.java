package lecture4.homework.correction.fruits;

public class Apple extends Fruit {

  int id;

  public Apple(int id) {
    super(1.0f);
    this.id = id;
  }


  @Override
  public String toString() {
    return "Apple{" +
        "id=" + id +
        '}';
  }
}
