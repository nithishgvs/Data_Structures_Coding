package org.leetcode.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class FindCommonCharacters_1002 {

  public List<String> commonChars(String[] A) {

    List<String> list = new ArrayList<>();

    if (A.length <= 1) {
      return list;
    }

    Map<Character, Integer> map = new HashMap<>();

    for (int j = 0; j < A[0].length(); j++) {

      if (map.containsKey(A[0].charAt(j))) {
        map.put(A[0].charAt(j), map.get(A[0].charAt(j)) + 1);
      } else {
        map.put(A[0].charAt(j), 1);
      }
    }

    for (int k = 1; k < A.length; k++) {
      Map<Character, Integer> newMap = new HashMap<>();
      for (int j = 0; j < A[k].length(); j++) {
        if (map.containsKey(A[k].charAt(j)) &&!newMap.containsKey(A[k].charAt(j))) {
          newMap.put(A[k].charAt(j), map.get(A[k].charAt(j)));
        }

      }
      map = newMap;
    }

    return list;

  }


  @Test
  public void test() {
    commonChars(new String[]{"bella", "label", "roller"});
  }

}
