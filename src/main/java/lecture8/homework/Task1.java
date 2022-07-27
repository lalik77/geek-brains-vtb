package lecture8.homework;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {

  private static String [] words = {"Alex",
      "Heroku",
      "Amazon",
      "Alex",
      "Ivan"};

  public static void main(String[] args) {

    final long count = mostRepeatedWord(words);
    System.out.println(count);

  }

  public static long mostRepeatedWord(String[] words) {

    long maxRepeted=0;

    Map<String, Long> frequency ;
    frequency = Stream.of(words).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

    final Optional<Entry<String, Long>> max = frequency.entrySet().stream()
        .max(Comparator.comparing(Entry::getValue)
        );

    if (max.isPresent()) {
      maxRepeted = max.get().getValue();

    }
    if (maxRepeted == 1)
      return 0;

    return maxRepeted;
  }


}
