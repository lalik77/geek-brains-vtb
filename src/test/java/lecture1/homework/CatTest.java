package lecture1.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CatTest {

  @Test
  void catRunTestSuccess() {
    Animal animal = new Cat("Tommy");
    animal.run(150);
    Assertions.assertNotNull(animal);
    Assertions.assertEquals("Tommy - кошка.Tommy пробежал 150.0 м.", animal.getMessage());
  }

  @Test
  void catCannotRunTest() {
    Animal animal = new Cat("Tommy");
    animal.run(345);
    Assertions.assertNotNull(animal);
    Assertions.assertEquals("Tommy - кошка.А кошки не могут пробежать больше чем 200.0 метров!",
        animal.getMessage());
  }

  @Test
  void catCannotSwim() {
    Animal animal = new Cat("Tommy");
    animal.swim(1);
    Assertions.assertNotNull(animal);
    Assertions.assertEquals("Tommy - кошка.А кошки не умеют плавать!",
        animal.getMessage());
  }
}