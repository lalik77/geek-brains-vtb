package lecture4.homework.task1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyArrayTest {

  @Test
  public void swapMyArrayAsStringSuccessTest() {

    String[] stringArray = {"asd","fgh", "jkl"};
    MyArray myArray=new MyArray(stringArray);

    final boolean isSwaped = myArray.swap(0, 2);

    assertTrue(isSwaped);
    assertEquals("jkl",stringArray[0]);
    assertEquals("asd",stringArray[2]);
  }

  @Test
  public void swapMyArrayAsIntegerSuccessTest() {

    Integer[] intArray = {1,34,56,78,90,34,56};
    MyArray myArray=new MyArray(intArray);

    final boolean isSwaped = myArray.swap(4, 0);

    assertTrue(isSwaped);
    assertEquals(90,intArray[0]);
    assertEquals(1,intArray[4]);
  }


  @Test
  public void swapMyArrayAsObjectFails_whenPassedFalseParamTest() {

    Object[] objArray = new Object[5];
    MyArray myArray=new MyArray(objArray);

    final boolean isSwaped = myArray.swap(5, 0);

    assertFalse(isSwaped);


  }

}