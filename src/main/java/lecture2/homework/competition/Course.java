package lecture2.homework.competition;

import lecture2.homework.model.Cat;
import lecture2.homework.model.Human;
import lecture2.homework.model.Robot;
import lecture2.homework.service.Competitive;

public class Course {

  private boolean isHumanCoursePassedWithSuccess;
  private boolean isCatCoursePassedWithSuccess;
  private boolean isRobotCoursePassedWithSuccess;
  private boolean isSuccess=true;

  public boolean runAndJump(Competitive[] competitives, int[] constrains) {

    for (Competitive c : competitives) {

      if (c instanceof Human) {
        constrains:
        for (int i = 0; i < constrains.length; i++) {
          Human human = (Human) c;

          if (human.run(new Treadmill(constrains[i])) && human.jump(new Wall(constrains[i]))) {
            isHumanCoursePassedWithSuccess = true;

          } else {
            isSuccess=false;
            System.out.println(
                "=============>> Human with id : " + human.getId()
                    + " quit the competition at constraints = "
                    + constrains[i] + " meter(s)");
            break constrains;
          }
        }
      }

      if (c instanceof Cat) {
        constrains:
        for (int i = 0; i < constrains.length; i++) {
          Cat cat = (Cat) c;

          if (cat.run(new Treadmill(constrains[i])) && cat.jump(new Wall(constrains[i]))) {
            isCatCoursePassedWithSuccess = true;

          } else {
            isSuccess=false;
            System.out.println(
                "=============>> Cat with id : " + cat.getId()
                    + " quit the competition at constraints = "
                    + constrains[i] + " meter(s)");
            break constrains;
          }
        }
      }

      if (c instanceof Robot) {
        constrains:
        for (int i = 0; i < constrains.length; i++) {
          Robot robot = (Robot) c;

          if (robot.run(new Treadmill(constrains[i])) && robot.jump(new Wall(constrains[i]))) {
            isRobotCoursePassedWithSuccess = true;

          } else {
            isSuccess=false;
            System.out.println(
                "=============>> Robot with id : " + robot.getId()
                    + " quit the competition at constraints = "
                    + constrains[i] + " meter(s)");
            break constrains;
          }
        }
      }
    }
    return isSuccess && isHumanCoursePassedWithSuccess && isCatCoursePassedWithSuccess
       && isRobotCoursePassedWithSuccess;
  }
}


