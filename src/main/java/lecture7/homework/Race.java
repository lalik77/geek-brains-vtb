package lecture7.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {

  private ArrayList<Stage> stages;

  public Race(Stage... stages) {
      this.stages = new ArrayList<>(Arrays.asList(stages));
    }
  public ArrayList<Stage> getStages() {
    return stages;
  }
}


