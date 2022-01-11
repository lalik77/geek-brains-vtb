package lecture2.homework.model;

import lecture2.homework.competition.Treadmill;
import lecture2.homework.competition.Wall;
import lecture2.homework.service.Jumpable;
import lecture2.homework.service.Runnable;

public class Robot implements Runnable, Jumpable {

  private int id;
  private int limitRun;
  private int limitJump;

  public Robot(int id, int limitRun, int limitJump) {
    this.id = id;
    this.limitRun = limitRun;
    this.limitJump = limitJump;
  }

  @Override
  public boolean run(Treadmill treadmill) {
    if (this.limitRun < treadmill.getLength()) {
      System.out.println(
          "[RUN]========> This robot with id: " + getId() + " cannot run over " + this.limitRun
              + " meter(s)");
      return false;
    }
    System.out.println("Robot with id : " + getId() + " ran with success!");
    return true;
  }

  @Override
  public boolean jump(Wall wall) {
    if (this.limitJump < wall.getHeight()) {
      System.out.println(
          "[JUMP]========> This robot with id: " + getId() + " cannot jump over " + this.limitJump
              + " meter(s)");
      return false;
    }
    System.out.println("Robot with id : " + getId() + " has jumped with success!");
    return true;
  }

  public int getId() {
    return id;
  }
}
