package lecture3.lesson;

public class MyLibException extends RuntimeException {

  public MyLibException() {
  }

  public MyLibException(String message) {
    super(message);
  }
}
