package lecture2.homework.model;

import lecture2.homework.competition.Treadmill;
import lecture2.homework.competition.Wall;
import lecture2.homework.service.Jumpable;
import lecture2.homework.service.Runnable;

public class Human implements Runnable, Jumpable {

  private int limitRun;
  private int limitJump;

  public Human(int limitRun, int limitJump) {
    this.limitRun = limitRun;
    this.limitJump = limitJump;
  }

  @Override
  public boolean jump(Wall wall) {

    if (this.limitJump < wall.getHeight()) {
      System.out.println("This human cannot jump over " + this.limitJump + " meter(s)");
      return false;
    }
    System.out.println("Human has jumped with success!");
    return true;
  }

  @Override
  public boolean run(Treadmill treadmill) {

    if (this.limitRun < treadmill.getLength()) {
      System.out.println("This human cannot run over " + this.limitRun + " meter(s)");
      return false;
    }
    System.out.println("Human ran with success!");
    return true;
  }
}
