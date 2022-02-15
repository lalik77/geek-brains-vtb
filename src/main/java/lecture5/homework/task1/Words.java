package lecture5.homework.task1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Words{

  public static Set<String> getUniqueWords(String[] words){

    if( words == null) throw new IllegalArgumentException();

    Set<String> strings = new HashSet<String>(Arrays.asList(words));

    return strings;

  }


  public static Map<String,Integer> countEachWord(String [] words) {

    if( words == null) throw new IllegalArgumentException();

   Map<String, Integer> map = new HashMap<>();
   Set<String> set =new HashSet<>();

   for (String s : words) {
     int count=1;
     final boolean isAdded = set.add(s);
     if (isAdded) {
       map.put(s,count++);
     }else {
       int currentCount = map.get(s);
       count = currentCount;
       map.put(s,++count);
     }
   }
    return map;
  }

}
