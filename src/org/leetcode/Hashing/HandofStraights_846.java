package org.leetcode.Hashing;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;

public class HandofStraights_846 {

  public boolean isNStraightHand(int[] hand, int W) {

    Map<Integer, Integer> map = new LinkedHashMap<>();

    Arrays.sort(hand);

    for (int i = 0; i < hand.length; i++) {
      if (!map.containsKey(hand[i])) {
        map.put(hand[i], 1);
      } else {
        map.put(hand[i], map.get(hand[i]) + 1);
      }
    }

    int j = 0;
    while (j < (hand.length / W)) {
      int i = 0;
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (W == 1) {
          entry.setValue(entry.getValue() - 1);
        } else {
          if (i == W - 1 && map.containsKey(entry.getKey() - 1)) {
            entry.setValue(entry.getValue() - 1);
          } else if (entry.getValue() > 0 && map.containsKey(entry.getKey() + 1)) {
            entry.setValue(entry.getValue() - 1);
          }
        }
        i++;
        if (i == W) {
          break;
        }
      }
      j++;
      map.entrySet().removeIf(entry -> entry.getValue() == 0);
    }
    return map.size() == 0;
  }


  @Test
  public void test1() {
    System.out.println(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
  }

  @Test
  public void test2() {
    System.out.println(isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
  }

  @Test
  public void test3() {
    System.out.println(isNStraightHand(new int[]{1, 2, 3}, 1));
  }

  @Test
  public void test4() {
    System.out.println(isNStraightHand(new int[]{1, 1, 2, 2, 3, 3}, 2));
  }


}
