package org.leetcode.Arrays;

import java.util.Arrays;
import org.junit.Test;

public class SquaresofaSortedArray_977 {

  public int[] sortedSquares(int[] A) {
    for (int i = 0; i < A.length; i++) {
      A[i] = (int) Math.pow(A[i], 2);
    }
    Arrays.sort(A);
    return A;
  }

  //-4,-1,0,3,10

  @Test
  public void test1(){
    int [] nums={-4,-1,0,3,10};
    System.out.println(sortedSquares(nums));
  }

}
