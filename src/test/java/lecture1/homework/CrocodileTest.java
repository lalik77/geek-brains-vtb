package lecture1.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrocodileTest {

  @Test
  void crocodileRunTestSuccess() {
    Animal animal = new Crocodile("Stan");
    animal.run(150);
    Assertions.assertNotNull(animal);
    Assertions.assertEquals("Stan - крокодил.А крокодилы не умеют бегать!", animal.getMessage());
  }

  @Test
  void crocodileSwimTestSuccess() {
    Animal animal = new Crocodile("Stan");
    animal.swim(299);
    Assertions.assertNotNull(animal);
    Assertions.assertEquals("Stan - крокодил.Stan пробежал 299.0 м.", animal.getMessage());
  }


  @Test
  void crocodileCannotRunTest() {
    Animal animal = new Crocodile("Stan");
    animal.run(1);
    Assertions.assertNotNull(animal);
    Assertions.assertEquals("Stan - крокодил.А крокодилы не умеют бегать!", animal.getMessage());
  }

}