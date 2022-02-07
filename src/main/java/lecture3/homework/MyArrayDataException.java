package lecture3.homework;

public class MyArrayDataException extends NumberFormatException {

  private int row;
  private int column;
  private String value;

  public MyArrayDataException(int row, int column, String[][] array) {

    super("Invalid data in ["+ row + "; " + column + "]: " + array[row][column] );

    this.row = row;
    this.column = column;
    this.value = array[column][row];
  }
}
