package org.leetcode.Hashing;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class VerifyinganAlienDictionary_953 {


  public boolean isAlienSorted(String[] words, String order) {

    Map<Character, Integer> dictionary = new HashMap<>();
    for (int i = 0; i < order.length(); i++) {
      dictionary.put(order.charAt(i), i);
    }

    for (int i = 1; i < words.length; i++) {

      String prev = words[i - 1];

      String current = words[i];

      if (!findSortingPerfect(dictionary, prev, current)) {
        return false;
      }


    }

    return true;
  }

  private boolean findSortingPerfect(Map<Character, Integer> dictionary, String prev,
      String current) {
    int l1 = 0;
    int l2 = 0;

    while (l1 < prev.length() && l2 < current.length()) {
      if (dictionary.get(prev.charAt(l1)) < dictionary.get(current.charAt(l2))) {
        return true;
      } else if (dictionary.get(prev.charAt(l1)) > dictionary.get(current.charAt(l2))) {
        return false;
      }
      l1++;
      l2++;
    }

    if (prev.length() > current.length()) {
      return false;
    } else {
      return true;
    }
  }

  @Test
  public void test() {
    System.out
        .println(isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
  }

  @Test
  public void test1() {
    System.out
        .println(isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
  }


}
