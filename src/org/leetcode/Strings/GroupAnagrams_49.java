package org.leetcode.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class GroupAnagrams_49 {

  public List<List<String>> groupAnagrams(String[] strs) {

    List<List<String>> outputList = new ArrayList<>();
    Map<String, List<String>> anagramMap = new HashMap<>();
    for (String str : strs) {
      char[] arr = str.toCharArray();
      Arrays.sort(arr);
      List<String> anagramList = null;
      if (!anagramMap.containsKey(String.valueOf(arr))) {
        anagramList = new ArrayList<>();
        anagramList.add(str);
        anagramMap.put(String.valueOf(arr), anagramList);
      } else {
        anagramList = anagramMap.get(String.valueOf(arr));
        anagramList.add(str);
        anagramMap.put(String.valueOf(arr), anagramList);
      }
    }

    for (Map.Entry<String, List<String>> entry : anagramMap.entrySet()) {
      outputList.add(entry.getValue());
    }

    return outputList;

  }


  @Test
  public void testGroupAnagrams() {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    groupAnagrams(strs);
  }


}
