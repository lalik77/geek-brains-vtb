package lecture1.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DogTest {

  @Test
  void dogRunTestSuccess() {
    Animal animal = new Dog("Bob");
    animal.run(150);
    Assertions.assertNotNull(animal);
    Assertions.assertEquals("Bob - собака.Bob пробежал 150.0 м.", animal.getMessage());
  }

  @Test
  void dogSwimTestSuccess() {
    Animal animal = new Dog("Bob");
    animal.swim(9.8);
    Assertions.assertNotNull(animal);
    Assertions.assertEquals("Bob - собака.Bob проплыл 9.8 м.", animal.getMessage());
  }

  @Test
  void dogCannotSwimTest() {
    Animal animal = new Dog("Bob");
    animal.swim(150);
    Assertions.assertNotNull(animal);
    Assertions.assertEquals("Bob - собака.А собаки не могут проплыть больше чем 10.0 метров!",
        animal.getMessage());
  }

  @Test
  void dogCannotRunTest() {
    Animal animal = new Dog("Bob");
    animal.run(600);
    Assertions.assertNotNull(animal);
    Assertions.assertEquals("Bob - собака.А собаки не могут пробежать больше чем 500.0 метров!",
        animal.getMessage());
  }
}