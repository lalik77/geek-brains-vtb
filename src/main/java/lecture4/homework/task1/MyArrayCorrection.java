package lecture4.homework.task1;

public class MyArrayCorrection {

  Object [] elements ;

  public MyArrayCorrection(Object[] elements) {
    this.elements = elements;
  }

  public boolean swap(int idx1,int idx2) {

    int max = elements.length-1;

    if(idx1>max || idx2>max) {
      return false;
     /* throw new IllegalArgumentException("Something wrong with indexes!" +
          "\nMax size of indexes is " + max);*/
    }

    final Object element = elements[idx1];
    elements[idx1] = elements[idx2];
    elements[idx2] = element;
    return true;
  }

}
