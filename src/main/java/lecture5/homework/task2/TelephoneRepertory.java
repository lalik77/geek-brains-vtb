package lecture5.homework.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneRepertory<T> {

  private final Map<String,String> map;

  public TelephoneRepertory() {
    this.map = new HashMap<>();
  }

  public boolean addTelephoneNumber(String name,String phoneNumber) {
    if(name==null && phoneNumber==null) {
      return false;
    }
    map.put(phoneNumber,name);
    return true;
  }

  public List<String> getTelephoneNumberByName(String name) {

    if(name==null) {
      throw new IllegalArgumentException();
    }

    List<String> list = new ArrayList<>();

    for (Map.Entry<String, String> entry : map.entrySet()) {
      final String value = entry.getValue();
      if(value.equals(name)) list.add(entry.getKey());
    }

    return list;
  }
}
