package org.nithishgvs.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class JohnDeere {

  public static List<String> deviceNamesSystem(List<String> deviceNames) {
    List<String> result = new ArrayList<>();

    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < deviceNames.size(); i++) {
      if (!map.containsKey(deviceNames.get(i))) {
        result.add(deviceNames.get(i));
      } else {
        result.add(deviceNames.get(i) + map.get(deviceNames.get(i)));
      }
      map.put(deviceNames.get(i), map.getOrDefault(deviceNames.get(i), 0) + 1);
    }
    return result;

  }

  @Test
  public void test() {
    System.out
        .println(deviceNamesSystem(Arrays.asList("lamp", "lamp", "tv", "lamp")));
  }


}
