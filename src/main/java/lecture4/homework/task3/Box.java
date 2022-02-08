package lecture4.homework.task3;

import java.util.ArrayList;
import java.util.Objects;

public class Box<T> {

  private ArrayList<T> listOfFruits;
  private float fruitWeight;
  private float boxWeight;

  public Box(ArrayList<T> listOfFruits) {
    this.listOfFruits = listOfFruits;
    final T t = listOfFruits.get(0);
    if (t instanceof Apple) {
      fruitWeight = Apple.APPLE_WEIGHT;
    }

    if (t instanceof Orange) {
      fruitWeight = Orange.ORANGE_WEIGHT;
    }
    boxWeight = listOfFruits.size() * fruitWeight;

  }

  public ArrayList<T> getListOfFruits() {
    return listOfFruits;
  }

  public float getWeight() {
    return boxWeight;
  }

  public boolean compare(Box<T> box ) {
    return this.equals(box);
  }

  public void pourOut(Box<T> box) {

    if( box.getListOfFruits() == null || this.isEmpty()) {
      throw new IllegalArgumentException("The Box is empty or box is null");
    }

    final ArrayList<T> listOfFruits = this.getListOfFruits();
    box.add(listOfFruits);
    this.listOfFruits.clear();

  }

  private void add(ArrayList<T> listOfFruits) {
    this.listOfFruits.addAll(listOfFruits);

  }

  private boolean isEmpty() {
    return listOfFruits.isEmpty();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Box<?> box = (Box<?>) o;
    return Float.compare(box.boxWeight, boxWeight) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(boxWeight);
  }
}
