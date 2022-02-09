package lecture4.homework.task3;

import java.util.ArrayList;

public class Box<T extends Fruit> {

  private ArrayList<T> listOfFruits;
  private float boxWeight;

  public Box() {
    listOfFruits = new ArrayList<>();
  }

  public ArrayList<T> getListOfFruits() {
    return listOfFruits;
  }

  public float getWeight() {

    if (listOfFruits.isEmpty()) {
      return 0;
    }

    final T t = listOfFruits.get(0);

    if (t instanceof Apple) {
      boxWeight = listOfFruits.size() * Apple.APPLE_WEIGHT;
    }

    if (t instanceof Orange) {
      boxWeight = listOfFruits.size() * Orange.ORANGE_WEIGHT;
    }

    return boxWeight;
  }

  public boolean compare(Box<T> box ) {
    return this.getWeight() == box.getWeight();
  }

  public boolean pourOut(Box<T> box) {

    if (box.getListOfFruits() == null) {
      throw new IllegalArgumentException("The box is null");
    }

    if (this.isEmpty()) {
      System.out.println("The Box is empty");
      return false;
      //throw new IllegalArgumentException("The Box is empty");
    }

    if(box.getListOfFruits().isEmpty()) {

      final ArrayList<T> listOfFruits = this.getListOfFruits();
      box.add(listOfFruits);
      this.listOfFruits.clear();
      return true;
    }

    final T t1 = this.getListOfFruits().get(0);
    final T t2 = box.getListOfFruits().get(0);

    if (t1 instanceof Apple && t2 instanceof Orange) {

      System.out.println("Cannot mix oranges and apples");
      return false;
    }
    if (t1 instanceof Orange && t2 instanceof Apple) {

      System.out.println("Cannot mix orange and apples");
      return false;
    }

    final ArrayList<T> listOfFruits = this.getListOfFruits();
    box.add(listOfFruits);
    this.listOfFruits.clear();

    return true;

  }

  private void add(ArrayList<T> listOfFruits) {
    this.listOfFruits.addAll(listOfFruits);

  }

  private boolean isEmpty() {
    return listOfFruits.isEmpty();
  }

  public void push(T fruit) {

    if (listOfFruits.isEmpty()) {
      listOfFruits.add(fruit);
      return;
    }

    if (!listOfFruits.isEmpty()) {

      if (isTheSameFruit(fruit)) {
        listOfFruits.add(fruit);
        return;
      } else {
        throw new IllegalArgumentException("You have tried to put incorrect Fruit into the box");
      }
    }
    listOfFruits.add(fruit);
  }

  private boolean isTheSameFruit(T fruit) {

    boolean bothAreApple = this.listOfFruits.get(0) instanceof Apple && fruit instanceof Apple;

    if (bothAreApple) {
      return true;
    }
    boolean bothAreOrange = this.listOfFruits.get(0) instanceof Orange && fruit instanceof Orange;

    if (bothAreOrange) {
      return true;
    }
    return false;
  }


}
