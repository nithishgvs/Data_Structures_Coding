package org.leetcode.Arrays;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;

public class NumberofEquivalentDominoPairs_1128 {


  public int numEquivDominoPairs(int[][] dominoes) {

    int pairs = 0;

    Map<String, Integer> countMap = new LinkedHashMap<>();

    for (int[] arr : dominoes) {
      int x = Math.min(arr[0], arr[1]);
      int y = Math.max(arr[0], arr[1]);
      String key = x + ":" + y;
      if (!countMap.containsKey(key)) {
        countMap.put(key, 1);
      } else {
        countMap.put(key, countMap.get(key) + 1);
      }
    }

    for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
      if (entry.getValue() > 1) {
        pairs += (entry.getValue() * (entry.getValue() - 1)) / 2;
      }
    }

    return pairs;

  }


  @Test
  public void test1() {
    System.out.println(numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}));
  }

  @Test
  public void test2() {
    System.out.println(numEquivDominoPairs(new int[][]{{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}}));
  }
}
