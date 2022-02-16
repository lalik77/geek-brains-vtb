package lecture4.homework.correction.fruits;

public class Orange extends Fruit{

  int id;

  public Orange(int id) {
    super(1.5f);
    this.id=id;
  }

  @Override
  public String toString() {
    return "Orange{" +
        "id=" + id +
        '}';
  }
}
