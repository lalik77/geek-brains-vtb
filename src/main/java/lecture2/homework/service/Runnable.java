package lecture2.homework.service;

import lecture2.homework.competition.Treadmill;
import lecture2.homework.competition.Wall;

public interface Runnable extends Competitive {

  boolean run(Treadmill treadmill);

}
