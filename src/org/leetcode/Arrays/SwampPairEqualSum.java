package org.leetcode.Arrays;

import org.junit.Test;

public class SwampPairEqualSum {


  public int[] findSwapPairEqualSum(int[] array1, int[] array2) {
    int sum1 = 0;
    int sum2 = 0;
    for (int i = 0; i < array1.length; i++) {
      sum1 += array1[i];

    }
    for (int i = 0; i < array2.length; i++) {
      sum2 += array2[i];
    }

    if (sum1 < sum2) {
      return findPair(sum2 - sum1, array1, array2, sum1, sum2, true);
    } else {
      return findPair(sum1 - sum2, array2, array1, sum2, sum1, false);
    }

  }

  private int[] findPair(int sumDiff, int[] array1, int[] array2, int sum1, int sum2,
      boolean flag) {

    int i = 1;
    int[] outArray = new int[2];
    while (i < sumDiff) {
      int other = sumDiff - i;
      if (elementExists(array1, i) && elementExists(array2, other)) {
        if ((sum1 - i + other) == (sum2 - other + i)) {
          if (flag) {
            outArray[0] = i;
            outArray[1] = other;
            break;
          } else {
            outArray[0] = other;
            outArray[1] = i;
            break;
          }
        }
      }
      i++;

    }
    return outArray;

  }

  private boolean elementExists(int[] array, int element) {

    for (int i = 0; i < array.length; i++) {
      if (array[i] == element) {
        return true;
      }
    }
    return false;
  }


  @Test
  public void findSwapPair1() {

    int[] array1 = {4, 1, 2, 1, 1, 2};
    int[] array2 = {3, 6, 3, 3};

    findSwapPairEqualSum(array2, array1);


  }

  @Test
  public void findSwapPair2() {

    int[] array1 = {5, 7, 4, 6};
    int[] array2 = {1, 2, 3, 8};

    findSwapPairEqualSum(array2, array1);


  }


}
