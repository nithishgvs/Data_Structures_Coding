package org.leetcode.Strings;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class FindWordsThatCanBeFormedbyCharacters_1160 {


  public int countCharacters(String[] words, String chars) {

    Map<Character, Integer> map1 = new HashMap<>();

    int count = 0;

    for (char c : chars.toCharArray()) {
      if (!map1.containsKey(c)) {
        map1.put(c, 1);
      } else {
        map1.put(c, map1.get(c) + 1);
      }
    }

    for (String word : words) {
      Map<Character, Integer> map2 = new HashMap<>();
      for (char c : word.toCharArray()) {
        if (!map2.containsKey(c)) {
          map2.put(c, 1);
        } else {
          map2.put(c, map2.get(c) + 1);
        }
      }
      boolean flag = false;
      for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
        if (!map1.containsKey(entry.getKey())) {
          flag = true;
          break;
        }
        if (map1.get(entry.getKey()) < entry.getValue()) {
          flag = true;
          break;
        }
      }
      if (!flag) {
        count += word.length();
      }
    }

    return count;
  }


  @Test
  public void test1() {
    System.out.println(countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
  }


}
