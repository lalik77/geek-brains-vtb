package lecture1.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TigerTest {

  @Test
  void tigerRunTestSuccess() {
    Animal animal = new Tiger("Rocky");
    animal.run(1999.4);
    Assertions.assertNotNull(animal);
    Assertions.assertEquals("Rocky - тигр.Rocky пробежал 1999.4 м.", animal.getMessage());
  }

  @Test
  void tigerCannotRunTest() {
    Animal animal = new Tiger("Rocky");
    animal.run(2003.7);
    Assertions.assertNotNull(animal);
    Assertions.assertEquals("Rocky - тигр.А тигры не могут пробежать больше чем 2000.0 метров!",
        animal.getMessage());
  }

  @Test
  void tigerSwimSuccess() {
    Animal animal = new Tiger("Rocky");
    animal.swim(12);
    Assertions.assertNotNull(animal);
    Assertions.assertEquals("Rocky - тигр.Rocky проплыл 12.0 м.",
        animal.getMessage());
  }

  @Test
  void tigerCannotSwim() {
    Animal animal = new Tiger("Rocky");
    animal.swim(13);
    Assertions.assertNotNull(animal);
    Assertions.assertEquals("Rocky - тигр.А тигры не могут проплыть больше чем 12.0 метров!",
        animal.getMessage());
  }
}