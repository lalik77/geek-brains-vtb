package lecture2.homework.service;

import lecture2.homework.competition.Treadmill;
import lecture2.homework.competition.Wall;

public interface Jumpable extends Competitive
{

  boolean jump(Wall wall);

}
