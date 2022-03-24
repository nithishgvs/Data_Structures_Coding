package org.twentytwentytwo.practice;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class RomantoInteger_13 {

  public int romanToInt(String s) {

    int number = 0;

    Map<String, Integer> map = new HashMap() {{
      put("I", 1);
      put("IV", 4);
      put("V", 5);
      put("IX", 9);
      put("X", 10);
      put("XL", 40);
      put("L", 50);
      put("XC", 90);
      put("C", 100);
      put("CD", 400);
      put("D", 500);
      put("CM", 900);
      put("M", 1000);
    }};

    for (int i = 0; i < s.length(); i++) {
      char currChar = s.charAt(i);
      String twoChars = "";
      if (s.length() - i >= 2) {
        twoChars = s.substring(i, i + 2);
      }
      if (map.containsKey(twoChars)) {
        number += map.get(twoChars);
        i++;
      } else {
        number += map.get(String.valueOf(currChar));
      }
    }

    return number;

  }

  @Test
  public void test() {
    System.out.println(romanToInt("MCMXCIV"));
  }

}
