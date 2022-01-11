package lecture2.homework;

import lecture2.homework.competition.Course;
import lecture2.homework.model.Cat;
import lecture2.homework.model.Human;
import lecture2.homework.model.Robot;
import lecture2.homework.service.Competitive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainAppTest {

  @Test
  public void runAndJumpTestFail() {

    Human human1 = new Human(1,60, 10);
    Human human2 = new Human(2,60, 40);
    Human human3 = new Human(3,13, 45);
    Cat cat1 = new Cat(1,60,10);
    Cat cat2 = new Cat(2,60,40);
    Cat cat3 = new Cat(3,13,45);
    Robot robot1 = new Robot(1,60,10);
    Robot robot2 = new Robot(2,60,40);
    Robot robot3 = new Robot(3,13,45);
    Course course = new Course();
    boolean isSuccess = false;
    Competitive[] competitives = {human1, human2, human3,cat1,cat2,cat3,robot1,robot2,robot3};

    int[] constrains = {10, 20, 30, 40, 50};

    isSuccess = course.runAndJump(competitives,constrains);

    Assertions.assertFalse(isSuccess);
  }

  @Test
  public void runAndJumpTestSuccess() {

    Human human1 = new Human(1,60, 60);
    Human human2 = new Human(2,52, 52);
    Human human3 = new Human(3,50, 50);
    Cat cat1 = new Cat(1,60,60);
    Cat cat2 = new Cat(2,52,52);
    Cat cat3 = new Cat(3,50,50);
    Robot robot1 = new Robot(1,60,50);
    Robot robot2 = new Robot(2,52,50);
    Robot robot3 = new Robot(3,50,50);
    Course course = new Course();
    boolean isSuccess = false;
    Competitive[] competitives = {human1, human2, human3,cat1,cat2,cat3,robot1,robot2,robot3};

    int[] constrains = {10, 20, 30, 40, 50};

    isSuccess = course.runAndJump(competitives,constrains);

    Assertions.assertTrue(isSuccess);
  }
}

