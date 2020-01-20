package org.leetcode.Arrays;

import java.util.Arrays;
import org.junit.Test;

public class TwoSumLessThanK_1099 {

  public int twoSumLessThanK(int[] A, int K) {

    Arrays.sort(A);

    int soFarValue = -1;

    int i = 0, j = A.length - 1;

    while (i < j) {

      if (A[i] + A[j] < K) {
        soFarValue = Math.max(A[i] + A[j], soFarValue);
        i++;
      } else {
        j--;
      }

    }


    return soFarValue;
  }


  @Test
  public void test() {
    int[] A = new int[]{34, 23, 1, 24, 75, 33, 54, 8};
    System.out.println(twoSumLessThanK(A, 60));

  }

  @Test
  public void test1() {
    int[] A = new int[]{10, 20, 30};
    System.out.println(twoSumLessThanK(A, 15));

  }

  @Test
  public void test2() {
    int[] A = new int[]{100};
    System.out.println(twoSumLessThanK(A, 200));

  }

  @Test
  public void test4() {
    int[] A = new int[]{254, 914, 110, 900, 147, 441, 209, 122, 571, 942, 136, 350, 160, 127, 178,
        839, 201, 386, 462, 45, 735, 467, 153, 415, 875, 282, 204, 534, 639, 994, 284, 320, 865,
        468, 1, 838, 275, 370, 295, 574, 309, 268, 415, 385, 786, 62, 359, 78, 854, 944};
    System.out.println(twoSumLessThanK(A, 200));

  }
}
