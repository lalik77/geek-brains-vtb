package lecture1.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WolfTest {

  @Test
  void wolfRunTestSuccess() {
    Animal animal = new Wolf("Barry");
    animal.run(150);
    Assertions.assertNotNull(animal);
    Assertions.assertEquals("Barry - волк.Barry пробежал 150.0 м.", animal.getMessage());
  }

  @Test
  void wolfSwimTestSuccess() {
    Animal animal = new Wolf("Barry");
    animal.swim(11.9);
    Assertions.assertNotNull(animal);
    Assertions.assertEquals("Barry - волк.Barry проплыл 11.9 м.", animal.getMessage());
  }

  @Test
  void wolfCannotSwimTest() {
    Animal animal = new Wolf("Barry");
    animal.swim(12.9);
    Assertions.assertNotNull(animal);
    Assertions.assertEquals("Barry - волк.А волки не могут проплыть больше чем 12.0 метров!",
        animal.getMessage());
  }

  @Test
  void wolfСannotRunTest() {
    Animal animal = new Wolf("Barry");
    animal.run(1002);
    Assertions.assertNotNull(animal);
    Assertions.assertEquals("Barry - волк.А волки не могут пробежать больше чем 1000.0 метров!",
        animal.getMessage());
  }
}