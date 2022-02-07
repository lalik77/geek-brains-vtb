package lecture3.homework;

public class Matrix {

  public static int sumOfElementsInMatrix(String[][] strArr) {

    if (strArr.length != 4) {
      throw new MyArraySizeException("Incorrect array size [x][]");
    } else if (
        strArr[0].length != 4
            || strArr[1].length != 4
            || strArr[2].length != 4
            || strArr[3].length != 4) {
      throw new MyArraySizeException("Incorrect array size [][x]");
    }

    int sum = 0;

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (!containsOnlyDigit(strArr[i][j])) {
          throw new MyArrayDataException(i,j,strArr);
        }
        sum += Integer.parseInt(strArr[i][j]);
      }
    }

    return sum;
  }

  private static boolean containsOnlyDigit(String str) {

    return !str.chars()
        .anyMatch(n -> !Character.isDigit(n));
  }

}
