package lecture4.homework;

import java.util.ArrayList;
import lecture4.homework.task1.MyArray;
import lecture4.homework.task3.Apple;
import lecture4.homework.task3.Box;
import lecture4.homework.task3.Fruit;
import lecture4.homework.task3.Orange;

public class MainApp {

  public static void main(String[] args) {

    ArrayList<Fruit> apples = new ArrayList<>();
    apples.add(new Apple(1));
    apples.add(new Apple(2));
    apples.add(new Apple(3));
    apples.add(new Apple(4));
    apples.add(new Apple(5));
    apples.add(new Apple(6));

    Box<Fruit> applesBox=new Box<>(apples);

    System.out.println(applesBox.getListOfFruits());
    System.out.println(applesBox.getWeight());


    ArrayList<Fruit> oranges = new ArrayList<>();
    oranges.add(new Orange(23));
    oranges.add(new Orange(24));
    oranges.add(new Orange(25));
    oranges.add(new Orange(26));

    Box<Fruit> orangeBox = new Box<>(oranges);
    System.out.println(orangeBox.getListOfFruits());
    System.out.println(orangeBox.getWeight());

    //Method compare
    System.out.println(applesBox.compare(orangeBox));

    // Method pourOut

    ArrayList<Fruit> oranges2 = new ArrayList<>();
    oranges2.add(new Orange(1));
    oranges2.add(new Orange(2));
    oranges2.add(new Orange(3));
    oranges2.add(new Orange(4));

    Box<Fruit> orangeBox2 = new Box<>(oranges2);

    orangeBox.pourOut(orangeBox2);

    System.out.println(orangeBox2.getListOfFruits());
    System.out.println(orangeBox.getListOfFruits());






  }

}