package lecture2.homework;

import lecture2.homework.competition.Course;
import lecture2.homework.model.Human;
import lecture2.homework.service.Competitive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainAppTest {

  @Test
  public void runAndJumpTest() {

    //Arrange
    Human human1 = new Human(1,60, 10);
    Human human2 = new Human(2,60, 40);
    Human human3 = new Human(3,13, 45);
    Course course = new Course();
    boolean isSuccess = false;
    Competitive[] competitives = {human1, human2, human3};
    //Act
    int[] constrains = {10, 20, 30, 40, 50};

    isSuccess = course.runAndJump(competitives,constrains);
    //Assert
    Assertions.assertFalse(isSuccess);

  }
}

