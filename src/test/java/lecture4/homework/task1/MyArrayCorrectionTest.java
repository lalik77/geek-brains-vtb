package lecture4.homework.task1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyArrayCorrectionTest {

  @Test
  public void swapMyArrayAsStringSuccessTest() {

    String[] stringArray = {"asd","fgh", "jkl"};
    MyArrayCorrection myArray=new MyArrayCorrection(stringArray);

    final boolean isSwapped = myArray.swap(0, 2);

    assertTrue(isSwapped);
    assertEquals("jkl",stringArray[0]);
    assertEquals("asd",stringArray[2]);
  }

  @Test
  public void swapMyArrayAsIntegerSuccessTest() {

    Integer[] intArray = {1,34,56,78,90,34,56};
    MyArrayCorrection myArray=new MyArrayCorrection(intArray);

    final boolean isSwapped = myArray.swap(4, 0);

    assertTrue(isSwapped);
    assertEquals(90,intArray[0]);
    assertEquals(1,intArray[4]);
  }


  @Test
  public void swapMyArrayAsObjectFails_whenPassedFalseParamTest() {

    Object[] objArray = new Object[5];
    MyArrayCorrection myArray=new MyArrayCorrection(objArray);

    final boolean isSwapped = myArray.swap(5, 0);

    assertFalse(isSwapped);


  }

}