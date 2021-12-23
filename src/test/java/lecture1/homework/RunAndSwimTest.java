package lecture1.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RunAndSwimTest {

  private final static Animal[] animals = new Animal[] {
          new Dog("Bob"),
          new Dog("Hector"),
          new Cat("Murzik"),
          new Cat("Tommy"),
          new Wolf("Barry"),
          new Tiger("John"),
          new Crocodile("Ivan")
  };

  @Test
  void runAndSwimTest() {
    boolean isRunAndSwim = RunAndSwim.runAndSwim(animals);
    Assertions.assertTrue(isRunAndSwim);
  }

  @Test
  void runAndSwimThrowsExceptionTest() {
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> RunAndSwim.runAndSwim(null));
  }

  @Test
  public void countNumberOfAnimals() {
    long countNumberOfAnimals = RunAndSwim.getNumberOfAnimals(animals);
    Assertions.assertEquals(7,countNumberOfAnimals);
  }

  @Test
  public void countNumberOfDogs() {
    long countNumberOfDogs = RunAndSwim.getNumberOfDogs(animals);
    Assertions.assertEquals(2,countNumberOfDogs);
  }

  @Test
  public void countNumberOfCats() {
    long countNumberOfCats = RunAndSwim.getNumberOfCats(animals);
    Assertions.assertEquals(2,countNumberOfCats);
  }

  @Test
  public void countNumberOfTigers() {
    long countNumberOfTigers = RunAndSwim.getNumberOfTigers(animals);
    Assertions.assertEquals(1,countNumberOfTigers);
  }

  @Test
  public void countNumberOfDogsReturnsMinisOne_whenEmptyArrayIsPassed() {

    Animal[] animals = new Animal[] { };

    long numberOfDogs = RunAndSwim.getNumberOfDogs(animals);

    Assertions.assertEquals(-1,numberOfDogs);
  }

  @Test
  public void countNumberOfAnimalsReturnsMinisOne_whenEmptyArrayIsPassed() {

    Animal[] animals = new Animal[] { };

    long numberOfDogs = RunAndSwim.getNumberOfAnimals(animals);

    Assertions.assertEquals(-1,numberOfDogs);
  }

  @Test
  public void countNumberOfCatsReturnsMinisOne_whenEmptyArrayIsPassed() {

    Animal[] animals = new Animal[] { };

    long numberOfCats = RunAndSwim.getNumberOfCats(animals);

    Assertions.assertEquals(-1,numberOfCats);
  }

  @Test
  public void countNumberOfTigersReturnsMinisOne_whenEmptyArrayIsPassed() {

    Animal[] animals = new Animal[] { };

    long numberOfTigers = RunAndSwim.getNumberOfTigers(animals);

    Assertions.assertEquals(-1,numberOfTigers);
  }
}