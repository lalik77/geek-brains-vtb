package lecture3.homework;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MainAppTest {

  @Test
  public void sumOfElementsInMatrixSuccessTest() {
    //given
    String[][] str1 = {
        {"1", "1", "1", "1",},
        {"1", "1", "1", "1"},
        {"1", "1", "1", "1"},
        {"1", "1", "1", "1"},
    };

    String[][] str2 = {
        {"0", "0", "0", "0",},
        {"0", "0", "0", "0"},
        {"0", "0", "0", "0"},
        {"0", "0", "0", "0"},
    };

    String[][] str3 = {
        {"5", "5", "5", "5",},
        {"5", "5", "5", "5"},
        {"5", "5", "5", "5"},
        {"5", "5", "5", "5"},
    };

    //when
    final int sum1 = Matrix.sumOfElementsInMatrix(str1);
    final int sum2 = Matrix.sumOfElementsInMatrix(str2);
    final int sum3 = Matrix.sumOfElementsInMatrix(str3);

    //then
    assertEquals(16, sum1);
    assertEquals(0, sum2);
    assertEquals(80, sum3);
  }


  @Test
  public void sumOfElementsInMatrixThrowMyArraySizeException() {
    //given
    String[][] str1 = {
        {"1", "1", "1", "1",},
        {"1", "1", "1", "1"},
        {"1", "1", "1", "1"},
        {"1", "1", "1", "1"},
        {"1", "1", "1", "1"},
    };
    String[][] str2 = {
        {"0", "0", "0", "0", "9"},
        {"0", "0", "0", "0"},
        {"0", "0", "0", "0"},
        {"0", "0", "0", "0"},
    };

    assertThrows(MyArraySizeException.class, () -> Matrix.sumOfElementsInMatrix(str1));
    assertThrows(MyArraySizeException.class, () -> Matrix.sumOfElementsInMatrix(str2));

  }

  @Test
  public void sumOfElementsInMatrixThrowMyDataException() {
    //given
    String[][] str1 = {
        {"1", "2e", "1", "1",},
        {"1", "1", "1", "1"},
        {"1", "1", "1", "1"},
        {"1", "1", "1", "1"},

    };
    //will fail
   // assertThrows(MyArraySizeException.class, () -> Matrix.sumOfElementsInMatrix(str1));

    assertThrows(MyArrayDataException.class, () -> Matrix.sumOfElementsInMatrix(str1));

  }

}