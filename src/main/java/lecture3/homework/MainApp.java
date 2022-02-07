package lecture3.homework;

public class MainApp {


  public static void main(String[] args) {

    String[][] str = {
        {"5", "5", "5", "5",},
        {"5", "5", "5", "5"},
        {"5", "5", "5", "5"},
        {"5", "5", "5s", "5"},
    };

    System.out.println(Matrix.sumOfElementsInMatrix(str));

  }


}