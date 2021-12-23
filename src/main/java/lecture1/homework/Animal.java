package lecture1.homework;

public abstract class Animal {

  private String message;

  abstract void print(String message);

  abstract void swim(double distance);

  abstract void run(double distance);

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
