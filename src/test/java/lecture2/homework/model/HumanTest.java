package lecture2.homework.model;

import static org.junit.jupiter.api.Assertions.*;

import lecture2.homework.competition.Treadmill;
import lecture2.homework.competition.Wall;
import org.junit.jupiter.api.Test;

class HumanTest {

  @Test
  public void humanJumpTest_withSuccess() {

    Wall wall =new Wall(10);
    Human human = new Human(1,32,34);

    boolean isSuccess = human.jump(wall);

    assertTrue(isSuccess);
  }

  @Test
  public void humanJumpTest_withoutSuccess() {

    Wall wall=new Wall(10);
    Human human = new Human(2,9,9);

    boolean isSuccess = human.jump(wall);

    assertFalse(isSuccess);
  }

  @Test
  public void humanRunTest_withSuccess() {

    Treadmill treadmill = new Treadmill(12);
    Human human = new Human(3,32,34);

    boolean isSuccess = human.run(treadmill);

    assertTrue(isSuccess);
  }

  @Test
  public void humanRunTest_withoutSuccess() {

    Treadmill treadmill = new Treadmill(12);
    Human human = new Human(4,6,34);

    boolean isSuccess = human.run(treadmill);

    assertFalse(isSuccess);
  }

}