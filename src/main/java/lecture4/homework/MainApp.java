package lecture4.homework;

import lecture4.homework.correction.fruits.Apple;
import lecture4.homework.correction.fruits.Fruit;
import lecture4.homework.correction.fruits.FruitBox;
import lecture4.homework.correction.fruits.Orange;

public class MainApp {

  public static void main(String[] args) {

    FruitBox<Apple> appleBox = new FruitBox<>(new Apple(1));
    FruitBox<Orange> orangeBox = new FruitBox<>(new Orange(1));
    FruitBox<Fruit> fruitBox  = new FruitBox<>();

    appleBox.transfer(fruitBox);
    //appleBox.transfer(orangeBox); // compile error
    //fruitBox.transfer(appleBox); // compile error

    orangeBox.transfer(fruitBox);;



  }

}