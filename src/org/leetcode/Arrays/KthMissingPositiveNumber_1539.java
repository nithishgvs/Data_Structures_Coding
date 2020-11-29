package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class KthMissingPositiveNumber_1539 {

  public int findKthPositive(int[] arr, int k) {

    List<Integer> list = new ArrayList<>();

    for (int i : arr) {
      list.add(i);
    }

    for (int i = 1; i < Integer.MAX_VALUE; i++) {

      if (!list.contains(i)) {
        k--;
        if (k == 0) {
          return i;
        }
      }
    }

    return 0;

  }

  @Test
  public void test() {
    System.out.println(findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
    System.out.println(findKthPositive(new int[]{1,2,3,4}, 2));
  }

}
