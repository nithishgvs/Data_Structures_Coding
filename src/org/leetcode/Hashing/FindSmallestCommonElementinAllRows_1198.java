package org.leetcode.Hashing;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class FindSmallestCommonElementinAllRows_1198 {


  public int smallestCommonElement(int[][] mat) {

    int result = Integer.MAX_VALUE;

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[0].length; j++) {
        int value = map.getOrDefault(mat[i][j], 0);
        value = value + 1;
        map.put(mat[i][j], value);
        if (value == mat.length) {
          result = Math.min(mat[i][j], result);
        }
      }
    }

    return result == Integer.MAX_VALUE ? -1 : result;

  }

  @Test
  public void test() {
    System.out.println(smallestCommonElement(
        new int[][]{{1, 2, 3, 4, 5}, {2, 4, 5, 8, 10}, {3, 5, 7, 9, 11}, {1, 3, 5, 7, 9}}));
  }

}
