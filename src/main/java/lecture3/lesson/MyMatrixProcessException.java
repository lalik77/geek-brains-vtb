package lecture3.lesson;

public class MyMatrixProcessException extends MyLibException {

  private int row;
  private int column;
  private int value;


  public MyMatrixProcessException(int row, int column, int[][] array) {

    super("Invalid data in ["+ row + "; " + column + "]: " + array[row][column] );
    this.row = row;
    this.column = column;
    this.value = array[column][row];
  }
}
