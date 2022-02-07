package lecture3.lesson;

public class MainApp {

  public static void main(String[] args) {
    // throw new MyLibException();

    int[][] arr = {
        {1, 2, 3},
        {4, 5, 12},
        {2, 8, 9}};

    for (int i=0 ; i<arr.length;i++) {

      for(int j=0 ; j< arr[i].length;j++) {

        if(arr[i][j] == 7 || arr[i][j] == 12 ) {
          throw new MyMatrixProcessException(i,j,arr);
        }
      }
    }

  };
}
