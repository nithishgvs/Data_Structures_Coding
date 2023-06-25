package org.practice.io.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class WordPattern_209 {


  public boolean wordPattern(String pattern, String s) {

    Map<Character, Integer> map = new HashMap<>();

    StringBuilder pattenBuilder1 = new StringBuilder();

    for (int i = 0; i < pattern.length(); i++) {
      if (!map.containsKey(pattern.charAt(i))) {
        map.put(pattern.charAt(i), i);
      }
      pattenBuilder1.append(map.get(pattern.charAt(i))).append("|");
    }

    String[] split = s.split("\\s+");
    Map<String, Integer> map2 = new HashMap<>();
    StringBuilder pattenBuilder2 = new StringBuilder();

    for (int i = 0; i < split.length; i++) {
      if (!map2.containsKey(split[i])) {
        map2.put(split[i], i);
      }
      pattenBuilder2.append(map2.get(split[i])).append("|");
    }

    return pattenBuilder1.toString().equals(pattenBuilder2.toString());
  }


  @Test
  public void test() {
    System.out.println(wordPattern("abba", "dog cat cat dog"));
  }
}
