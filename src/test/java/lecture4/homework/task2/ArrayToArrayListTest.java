package lecture4.homework.task2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayToArrayListTest {

  @Test
  public void convertArrayToArrauListSuccessTest() {

    String[] stringArray = {"asd","fgh", "jkl"};
   ArrayToArrayList arrayToArrayList = new ArrayToArrayList(stringArray);

    final ArrayList converted = arrayToArrayList.convert();

    final boolean isAnArrayList = converted instanceof ArrayList;

    assertTrue(isAnArrayList);
    assertEquals(3,converted.size());
    assertEquals(stringArray[0],converted.get(0));

  }

}