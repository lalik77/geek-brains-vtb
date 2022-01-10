package lecture2.homework.competition;

import lecture2.homework.model.Human;
import lecture2.homework.service.Competitive;

public class Course {

  private boolean isHumanSuccess;

  public boolean runAndJump(Competitive[] competitives, int[] constrains) {

    for (Competitive c : competitives) {

      if (c instanceof Human) {
        constrains: for (int i = 0; i < constrains.length; i++) {
          Human h = (Human) c;

          if (h.run(new Treadmill(constrains[i])) && h.jump(new Wall(constrains[i]))) {
            isHumanSuccess = true;

          } else {
            isHumanSuccess = false;
            System.out.println(
                "=============>> Human with id : " + h.getId() + " quit the competition at constraints = "
                    + constrains[i] + " meter(s)");
            break constrains;
          }
        }
      }
    }
    return isHumanSuccess;
  }
}


