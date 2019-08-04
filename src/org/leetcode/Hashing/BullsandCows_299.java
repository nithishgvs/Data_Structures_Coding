package org.leetcode.Hashing;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class BullsandCows_299 {

  public String getHint(String secret, String guess) {

    Map<Character, Integer> map = new HashMap<>();

    int cowCount = 0, bullCount = 0;

    for (int i = 0; i < secret.length(); i++) {
      char char1 = secret.charAt(i);
      char char2 = guess.charAt(i);
      if (char1 == char2) {
        bullCount++;
      } else {
        if (!map.containsKey(char1)) {
          map.put(char1, 1);
        } else {
          map.put(char1, map.get(char1) + 1);
        }
      }
    }

    for (int i = 0; i < secret.length(); i++) {
      char char1 = secret.charAt(i);
      char char2 = guess.charAt(i);
      if (char1 != char2) {
        if (map.containsKey(char2) && map.get(char2) > 0) {
          cowCount++;
          map.put(char2, map.get(char2) - 1);
        }
      }
    }

    return bullCount + "A" + cowCount + "B";
  }


  @Test
  public void test1() {
    System.out.println(getHint("1807", "7810"));
  }

  @Test
  public void test2() {
    System.out.println(getHint("1123", "0111"));
  }


}
