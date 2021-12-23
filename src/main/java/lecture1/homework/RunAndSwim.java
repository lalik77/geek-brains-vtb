package lecture1.homework;

import java.util.Arrays;

public class RunAndSwim {

  public static boolean runAndSwim(Animal[] animals) {

    if(animals==null) {
      System.out.println("Null pointer exception");
      throw new IllegalArgumentException();
    }

    if(!isValid(animals) ) {
      return false;
    }
    Arrays.stream(animals)
        .forEach(animal -> {
          animal.run(200);
          animal.swim(9);
        }) ;
    return true;
  }

  public static long getNumberOfAnimals(Animal[] animals) {

    if(animals==null) {
      System.out.println("Null pointer exception");
      throw new IllegalArgumentException();
    }

    if(!isValid(animals)) {
      return -1;
    }
    return Arrays.stream(animals)
        .count();
  }

  public static long getNumberOfDogs(Animal[] animals) {

    if(animals==null) {
      System.out.println("Null pointer exception");
      throw new IllegalArgumentException();
    }

    if(!isValid(animals)) {
      return -1;
    }
   return Arrays.stream(animals)
        .filter(animal -> animal instanceof Dog)
        .count();
  }

  public static long getNumberOfCats(Animal[] animals) {

    if(animals==null) {
      System.out.println("Null pointer exception");
      throw new IllegalArgumentException();
    }

    if(!isValid(animals)) {
      return -1;
    }
    return Arrays.stream(animals)
        .filter(animal -> animal instanceof Cat)
        .count();
  }

  public static long getNumberOfTigers(Animal[] animals) {

    if(animals==null) {
      System.out.println("Null pointer exception");
      throw new IllegalArgumentException();
    }

    if(!isValid(animals)) {
      return -1;
    }
    return Arrays.stream(animals)
        .filter(animal -> animal instanceof Tiger)
        .count();
  }

  private static boolean isValid(Animal[] animals) {

    if(animals.length==0 ) {
      System.out.println("[RunAndSwim] -  something went wrong in === > empty array ");
      return false;
    }
    return true;
  }
}
