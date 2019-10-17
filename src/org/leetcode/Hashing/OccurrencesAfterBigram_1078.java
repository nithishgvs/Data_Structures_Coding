package org.leetcode.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class OccurrencesAfterBigram_1078 {


  public String[] findOcurrences(String text, String first, String second) {

    List<String> list = new ArrayList<>();

    String[] arr = text.split("\\s+");

    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(first) && map.containsKey(second)) {
        if (map.get(first) == map.get(second) - 1) {
          list.add(arr[i]);
          map.remove(first);
          map.remove(second);
        }
      }

      if (arr[i].equals(first)) {
        map.put(first, i);
      } else if (arr[i].equals(second)) {
        map.put(second, i);
      }

    }

    return list.toArray(new String[0]);
  }

  @Test
  public void test1() {
    findOcurrences("alice is a good girl she is a good student", "a", "good");
  }

  @Test
  public void test2() {
    findOcurrences("we will we will rock you", "we", "will");
  }

}
