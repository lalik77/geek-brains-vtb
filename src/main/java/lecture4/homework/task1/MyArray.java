package lecture4.homework.task1;

import java.util.Arrays;

public class MyArray<T>{

  T[] elements ;

  public MyArray(T[] elements) {
    this.elements = elements;
  }

  public boolean swap(int idx1,int idx2) {

    int max = elements.length-1;

    if(idx1>max || idx2>max) {
      return false;
     /* throw new IllegalArgumentException("Something wrong with indexes!" +
          "\nMax size of indexes is " + max);*/
    }

    final T element = elements[idx1];
    elements[idx1] = elements[idx2];
    elements[idx2] = element;
    return true;
  }

  @Override
  public String toString() {
    return  Arrays.toString(elements) ;
  }
}
