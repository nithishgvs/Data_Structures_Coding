package org.twentytwentytwo.practice;

import org.junit.Test;

public class VerifyinganAlienDictionary_953 {

  int[] map;

  public boolean isAlienSorted(String[] words, String order) {

    map = new int[26];

    for (int i = 0; i < order.length(); i++) {
      map[order.charAt(i) - 'a'] = i;
    }

    for (int i = 0; i < words.length - 1; i++) {
      if (!lexicographicallyCheck(words[i], words[i + 1])) {
        return false;
      }

    }

    return true;

  }

  private boolean lexicographicallyCheck(String str1, String str2) {
    int l1 = str1.length();
    int l2 = str2.length();
    int i = 0, j = 0;
    while (i < l1 && j < l2) {
      if (map[str1.charAt(i) - 'a'] < map[str2.charAt(j) - 'a']) {
        return true;
      } else if (map[str1.charAt(i) - 'a'] > map[str2.charAt(j) - 'a']) {
        return false;
      }
      i++;
      j++;
    }
    if (l1 > l2) {
      return false;
    }
    return true;
  }

  @Test
  public void test() {
    String[] words = {"hello", "leetcode"};
    System.out.println(isAlienSorted(words, "hlabcdefgijkmnopqrstuvwxyz"));
  }

  @Test
  public void test2() {
    String[] words = {"kuvp", "q"};
    System.out.println(isAlienSorted(words, "ngxlkthsjuoqcpavbfdermiywz"));
  }
}
