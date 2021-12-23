package lecture1.homework;

public class MainApp {

  public static void main(String[] args) {

    Animal[] animals = new Animal[]{
        new Dog("Bob"),
        new Dog("Hector"),
        new Cat("Murzik"),
        new Cat("Tommy"),
        new Wolf("Barry"),
        new Tiger("John"),
        new Crocodile("Ivan"),
    };
    RunAndSwim.runAndSwim(animals);
    System.out.println("\nNumbers of animals - " + RunAndSwim.getNumberOfAnimals(animals));


  }


}