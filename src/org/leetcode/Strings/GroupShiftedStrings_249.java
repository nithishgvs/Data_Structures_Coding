package org.leetcode.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class GroupShiftedStrings_249 {

  public List<List<String>> groupStrings(String[] strings) {
    List<List<String>> groupStrings = new ArrayList<>();
    if (strings.length == 0 || strings == null) {
      return groupStrings;
    }
    HashMap<String, List<String>> groupMap = new HashMap<>();

    for (String string : strings) {
      StringBuilder key = new StringBuilder();
      for (int j = 0; j < string.length() - 1; j++) {
        int value1 = (int) string.charAt(j) - 97;
        int value2 = (int) string.charAt(j + 1) - 97;
        key.append(Math.floorMod(value1 - value2, 26));
      }
      List<String> list = groupMap.getOrDefault(key.toString(), new ArrayList<>());
      list.add(string);
      groupMap.put(key.toString(), list);
    }
    for (Map.Entry<String, List<String>> entry : groupMap.entrySet()) {
      groupStrings.add(entry.getValue());
    }

    return groupStrings;
  }


  @Test
  public void test1() {
    String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
    groupStrings(strings);
  }
}
