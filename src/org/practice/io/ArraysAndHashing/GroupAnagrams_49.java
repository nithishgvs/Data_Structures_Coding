package org.practice.io.ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class GroupAnagrams_49 {

  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    Map<String, List<String>> anagramMap = new HashMap<>();
    for (String str : strs) {
      char[] temp = str.toCharArray();
      Arrays.sort(temp);
      String tempString = String.valueOf(temp);
      List<String> innerList = anagramMap.getOrDefault(tempString, new ArrayList<>());
      innerList.add(str);
      anagramMap.put(tempString, innerList);
    }
    anagramMap.forEach((k, v) -> result.add(v));
    return result;
  }


  @Test
  public void test() {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    String[] str1 = {};
    String[] str2 = {"a"};
    groupAnagrams(str2);
  }

}
