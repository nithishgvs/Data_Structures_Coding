package org.leetcode.SlidingWindowTechnique;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class GrumpyBookstoreOwner_1052 {


  public int maxSatisfied(int[] customers, int[] grumpy, int X) {

    int max = 0;

    Map<Integer, Integer> grumpyMap = new HashMap<>();
    Map<Integer, Integer> unGrumpyMap = new HashMap<>();

    int grumpyIndex = 0;
    int unGrumpyIndex = 0;
    for (int i = 0; i < customers.length; i++) {
      if (grumpy[i] == 1) {
        Integer prevValue = grumpyMap.getOrDefault(i - 1, 0);
        grumpyMap.put(i, customers[i] + prevValue);
        unGrumpyMap.put(i, unGrumpyMap.getOrDefault(unGrumpyIndex, 0));
        grumpyIndex = i;
      } else {
        Integer prevValue = unGrumpyMap.getOrDefault(i - 1, 0);
        unGrumpyMap.put(i, customers[i] + prevValue);
        grumpyMap.put(i, grumpyMap.getOrDefault(grumpyIndex, 0));
        unGrumpyIndex = i;
      }
    }

    int start = 0;
    int end = 0;

    int grumpyValue = 0;

    int unGrumpyValue = 0;

    while (end < customers.length) {

      if (grumpy[end] == 1) {
        grumpyValue += customers[end];
      } else {
        unGrumpyValue += customers[end];
      }

      while (end - start + 1 == X) {
        int current =
            grumpyValue + unGrumpyValue - grumpyMap.getOrDefault(start - 1, 0) - unGrumpyMap
                .getOrDefault(start - 1, 0);
        int unGrumpNess =
            unGrumpyMap.get(customers.length - 1) - unGrumpyMap.get(end) + unGrumpyMap
                .getOrDefault(start - 1, 0);
        max = Math.max(max, current + unGrumpNess);
        start++;
      }
      end++;

    }

    return max;

  }


  @Test
  public void test1() {
    int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
    int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
    System.out.println(maxSatisfied(customers, grumpy, 3));
  }

}
