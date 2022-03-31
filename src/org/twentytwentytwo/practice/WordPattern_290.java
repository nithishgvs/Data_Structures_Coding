package org.twentytwentytwo.practice;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class WordPattern_290 {


  public boolean wordPattern(String pattern, String s) {

    String pattern1 = buildPattern(pattern);
    String pattern2 = buildPattern2(s);

    return pattern1.equals(pattern2);

  }

  private String buildPattern2(String s) {
    String[] arr = s.split("\\s+");
    Map<String, Integer> map = new HashMap<>();
    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < arr.length; i++) {
      String str = arr[i];
      if (!map.containsKey(str)) {
        map.put(str, i);
      }
      stringBuilder.append(map.get(str)).append("|");
    }
    return stringBuilder.toString();
  }

  private String buildPattern(String pattern) {

    Map<Character, Integer> map = new HashMap<>();
    StringBuilder stringBuilder = new StringBuilder();

    for (int i = 0; i < pattern.length(); i++) {
      char ch = pattern.charAt(i);
      if (!map.containsKey(ch)) {
        map.put(ch, i);
      }
      stringBuilder.append(map.get(ch)).append("|");
    }
    return stringBuilder.toString();
  }

  @Test
  public void test1(){
    System.out.println(wordPattern("abba","dog cat cat dog"));
  }

}
