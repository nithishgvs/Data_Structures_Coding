package org.leetcode.Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class LongestWordinDictionarythroughDeleting_524 {


  public String findLongestWord(String s, List<String> d) {
    String longestWord = "";

    Map<Character, Integer> sMap = buildMap(s);

    for (String value : d) {
      Map<Character, Integer> currMap = buildMap(value);
      System.out.println(value);
    }

    return longestWord;


  }

  private Map<Character, Integer> buildMap(String s) {
    Map<Character, Integer> map = new HashMap<>();

    for (char ch : s.toCharArray()) {
      int val = map.getOrDefault(ch, 0);
      map.put(ch, val + 1);
    }

    return map;

  }


  @Test
  public void test1() {
    System.out
        .println(findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
  }


  @Test
  public void test2() {
    System.out
        .println(findLongestWord("abpcplea", Arrays.asList("a", "b", "c")));
  }

  @Test
  public void test3() {
    System.out
        .println(findLongestWord("aewfafwafjlwajflwajflwafj",
            Arrays.asList("apple", "ewaf", "awefawfwaf", "awef", "awefe", "ewafeffewafewf")));
  }
}
