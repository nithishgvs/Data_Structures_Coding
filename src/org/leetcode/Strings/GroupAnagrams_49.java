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
      String tmp = new String(arr);
      anagramMap.putIfAbsent(tmp, new ArrayList<>());
      anagramMap.get(tmp).add(str);
    }
    outputList.addAll(anagramMap.values());
    return outputList;

  }


  @Test
  public void testGroupAnagrams() {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    groupAnagrams(strs).forEach(v -> v.forEach(v1 -> System.out.println(v1)));
  }
  //["cab","tin","pew","duh","may","ill","buy","bar","max","doc"]

  @Test
  public void testGroupAnagrams2() {
    String[] strs = {"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"};
    groupAnagrams(strs).forEach(v -> v.forEach(v1 -> System.out.println(v1)));
  }


  @Test
  public void testGroupAnagrams3() {
    String[] strs = {"duh", "ill"};
    groupAnagrams(strs).forEach(v -> v.forEach(v1 -> System.out.println(v1)));
  }


}
