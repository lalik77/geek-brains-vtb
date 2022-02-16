package lecture4.homework.correction.fruits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FruitBoxTest {

  @Test
  public void addFruitIntoBoxSuccessTest() {

    FruitBox<Fruit> fruitBox = new FruitBox();

    fruitBox.add(new Apple(1));
    fruitBox.add(new Apple(2));
    fruitBox.add(new Apple(3));
    final int size = fruitBox.getSize();

    Assertions.assertEquals(3,3);
  }

  @Test
  public void addFruitsIntoBoxSuccessTest() {

    Apple[] apples = {
        new Apple(1),
        new Apple(2),
        new Apple(3)
    };

    Orange[] oranges = {
        new Orange(1),
        new Orange(2),
        new Orange(3)
    };

    FruitBox<Fruit> fruitBox = new FruitBox();
    fruitBox.add(apples);
    fruitBox.add(oranges);
    final int size = fruitBox.getSize();

    Assertions.assertEquals(6,6);
    System.out.println(fruitBox);
  }
}