package lecture4.homework.task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoxTest {

  @Test
  public void pushFruitIntoBoxSuccessTest() {

    Box<Fruit> fruitBoxApple = new Box<>();
    Box<Fruit> fruitBoxOrange = new Box<>();

    fruitBoxApple.push(new Apple(1));
    fruitBoxApple.push(new Apple(2));

    fruitBoxOrange.push(new Orange(10));
    fruitBoxOrange.push(new Orange(11));
    fruitBoxOrange.push(new Orange(12));

    Assertions.assertEquals(2, fruitBoxApple.getListOfFruits().size());
    Assertions.assertEquals(3, fruitBoxOrange.getListOfFruits().size());
  }

  @Test
  public void pushDifferentFruitsIntoBoxFailTest() {

    Box<Fruit> fruitBoxApple = new Box<>();
    Box<Fruit> fruitBoxOrange = new Box<>();

    fruitBoxApple.push(new Apple(1));

    Assertions.assertThrows(IllegalArgumentException.class,
       () -> fruitBoxApple.push(new Orange(1)));

    fruitBoxOrange.push(new Orange(10));
    fruitBoxOrange.push(new Orange(11));

    Assertions.assertThrows(IllegalArgumentException.class,
        () -> fruitBoxOrange.push(new Apple(1)));
  }

  @Test
  public void getWeight_WhenBoxIsNotEmptyTest() {

    Box<Fruit> fruitBoxApple = new Box<>();
    Box<Fruit> fruitBoxOrange = new Box<>();

    fruitBoxApple.push(new Apple(1));
    fruitBoxApple.push(new Apple(2));

    fruitBoxOrange.push(new Orange(10));
    fruitBoxOrange.push(new Orange(11));

    final float appleBoxWeight = fruitBoxApple.getWeight();
    final float orangeBoxWeight = fruitBoxOrange.getWeight();

    Assertions.assertEquals(2, appleBoxWeight);
    Assertions.assertEquals(3, orangeBoxWeight);


  }

  @Test
  public void getWeight_WhenBoxIsEmptyTest() {

    Box<Fruit> fruitBoxApple = new Box<>();
    Box<Fruit> fruitBoxOrange = new Box<>();

    //when boxes are empty
    final float appleBoxWeight = fruitBoxApple.getWeight();
    final float orangeBoxWeight = fruitBoxOrange.getWeight();
    //then
    Assertions.assertTrue(appleBoxWeight == orangeBoxWeight);
    Assertions.assertEquals(0, appleBoxWeight);

  }

  @Test
  public void compareToAnotherBoxTest() {

    Box<Fruit> fruitBoxApple = new Box<>();
    Box<Fruit> fruitBoxOrange = new Box<>();

    fruitBoxApple.push(new Apple(1));
    fruitBoxApple.push(new Apple(2));
    fruitBoxApple.push(new Apple(3));
    //fruitBoxApple.push(new Orange(3)); // throws exception

    fruitBoxOrange.push(new Orange(10));
    fruitBoxOrange.push(new Orange(11));
    //fruitBoxOrange.push(new Apple(13));

    final float appleBoxWeight = fruitBoxApple.getWeight();
    final float orangeBoxWeight = fruitBoxOrange.getWeight();

    boolean isEqual = appleBoxWeight == orangeBoxWeight;

    //then
    Assertions.assertTrue(isEqual);

  }

  @Test
  public void pourOutToAnotherBoxSuccessTest() {

    Box<Fruit> fruitBoxApple1 = new Box<>();
    Box<Fruit> fruitBoxApple2 = new Box<>();

    fruitBoxApple1.push(new Apple(1));
    fruitBoxApple1.push(new Apple(2));
    fruitBoxApple1.push(new Apple(3));

    fruitBoxApple2.push(new Apple(20));
    fruitBoxApple2.push(new Apple(30));
    fruitBoxApple2.push(new Apple(40));

    fruitBoxApple1.pourOut(fruitBoxApple2);

    System.out.println(fruitBoxApple1.getListOfFruits());
    System.out.println(fruitBoxApple2.getListOfFruits());

    Assertions.assertEquals(6, fruitBoxApple2.getListOfFruits().size());
    Assertions.assertTrue(fruitBoxApple1.getListOfFruits().isEmpty());

  }

  @Test
  public void pourOutToAnotherBoxFailTest() {

    Box<Fruit> fruitBoxApple = new Box<>();
    Box<Fruit> fruitBoxOrange = new Box<>();

    fruitBoxApple.push(new Apple(1));
    fruitBoxApple.push(new Apple(2));
    fruitBoxApple.push(new Apple(3));

    fruitBoxOrange.push(new Orange(10));
    fruitBoxOrange.push(new Orange(11));
    fruitBoxOrange.push(new Orange(12));

    final boolean isPourOut = fruitBoxOrange.pourOut(fruitBoxApple);

    Assertions.assertFalse(isPourOut);
    Assertions.assertEquals(3, fruitBoxApple.getWeight());
    Assertions.assertEquals(4.5, fruitBoxOrange.getWeight());

  }

  @Test
  public void pourOutAnEmptyBoxTest() {

    Box<Fruit> fruitBoxApple = new Box<>();
    Box<Fruit> fruitBoxOrange = new Box<>();

    fruitBoxApple.push(new Apple(1));
    fruitBoxApple.push(new Apple(2));
    fruitBoxApple.push(new Apple(3));

    final boolean isPourOut = fruitBoxOrange.pourOut(fruitBoxApple);

    Assertions.assertFalse(isPourOut);
  }

  @Test
  public void pourOutToAnEmptyBoxSuccessTest() {

    Box<Fruit> fruitBoxApple1 = new Box<>();
    Box<Fruit> fruitBoxApple2 = new Box<>();

    fruitBoxApple1.push(new Apple(1));
    fruitBoxApple1.push(new Apple(2));
    fruitBoxApple1.push(new Apple(3));

    final boolean isPourOut = fruitBoxApple1.pourOut(fruitBoxApple2);

    Assertions.assertTrue(isPourOut);
  }
}