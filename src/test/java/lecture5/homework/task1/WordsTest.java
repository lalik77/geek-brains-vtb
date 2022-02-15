package lecture5.homework.task1;

import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordsTest {

  @Test
  public void getUniqueWordsReturnsOnlyUniqueWordsTest() {
    String[] words = {
        "Alex", // repeated
        "Al",
        "Bob",
        "Bobby",
        "Ivan",
        "Ivanov",
        "Alex", //repeated
        "Brown",
        "Petr",
        "John",
        "Helena",
        "Olga",
        "Helene",
        "Mohamed",
        "Ahmed",
        "Joshua"

    };

    final Set<String> uniqueWords = Words.getUniqueWords(words);

    System.out.println(uniqueWords);

    Assertions.assertEquals(15, uniqueWords.size());

  }

  @Test
  public void countEachWordTest() {

    String[] words = {
        "Alex", // repeated
        "Alex", // repeated
        "Bob", // repeated
        "Bob",// repeated
        "Ivan",
        "Ivanov",
        "Alex", //repeated
        "Brown",
        "Petr",
        "Mohamed", // repeated
        "Helena",
        "Olga",
        "Helene",
        "Mohamed",// repeated
        "Mohamed",// repeated
        "Joshua"
    };

    Map<String, Integer> map = Words.countEachWord(words);

    final Set<String> strings = map.keySet();
   // System.out.println(map);
    final Integer alex = map.get("Alex");
    final Integer mohamed = map.get("Mohamed");
    final Integer ivan = map.get("Ivan");
    final Integer ivanov = map.get("Ivanov");
    final Integer brown = map.get("Brown");
    final Integer petr = map.get("Petr");
    final Integer helena = map.get("Helena");
    final Integer olga = map.get("Olga");
    final Integer helene = map.get("Helene");
    final Integer joshua = map.get("Joshua");
    final Integer bob = map.get("Bob");

    Assertions.assertEquals(3,mohamed);
    Assertions.assertEquals(3,alex);
    Assertions.assertEquals(1,brown);
    Assertions.assertEquals(1,olga);
    Assertions.assertEquals(1,helene);
    Assertions.assertEquals(2,bob);
    Assertions.assertEquals(1,petr);
    Assertions.assertEquals(1,helena);
    Assertions.assertEquals(1,ivan);
    Assertions.assertEquals(1,joshua);
    Assertions.assertEquals(1,ivanov);
  }
}