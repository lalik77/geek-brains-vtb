package lecture4.homework.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToArrayList<T> {

  private T[] arr;

  public ArrayToArrayList(T[] arr) {
    this.arr = arr;
  }

  public ArrayList<T> convert() {

    final List<T> ts = Arrays.asList(arr);

    return new ArrayList<T>(ts);
  }
}
