package lecture2.homework;

import lecture2.homework.competition.Course;
import lecture2.homework.model.Cat;
import lecture2.homework.model.Human;
import lecture2.homework.model.Robot;
import lecture2.homework.service.Competitive;

public class MainApp {

  public static void main(String[] args) {

    Human human1 = new Human(1,60, 60);
    Human human2 = new Human(2,52, 52);
    Human human3 = new Human(3,50, 50);
    Human human4 = new Human(4,25, 50);

    Cat cat1 = new Cat(1,60,60);
    Cat cat2 = new Cat(2,52,52);
    Cat cat3 = new Cat(3,50,50);
    Cat cat4 = new Cat(4,14,45);

    Robot robot1 = new Robot(1,60,50);
    Robot robot2 = new Robot(2,52,50);
    Robot robot3 = new Robot(3,50,50);
    Robot robot4 = new Robot(4,34,34);

    Course course = new Course();
    int[] constrains = {10, 20, 30, 40, 50,60,70};

    Competitive[] competitive = {human1, human2, human3,human4,
        cat1,cat2,cat3,cat4,robot1,robot2,robot3,robot4};

    course.runAndJump(competitive,constrains);

  }


}