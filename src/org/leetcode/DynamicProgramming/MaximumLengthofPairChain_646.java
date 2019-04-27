package org.leetcode.DynamicProgramming;

import java.util.Arrays;
import org.junit.Test;

public class MaximumLengthofPairChain_646 {

  public int findLongestChain(int[][] pairs) {
    int[] pairChainLength = new int[pairs.length];
    Arrays.fill(pairChainLength, 1);

    //Sort array acc to the first integer value

    for (int i = 1; i < pairs.length; i++) {
      for (int j = 0; j < i; j++) {
        if (pairs[i][0] < pairs[j][0]) {
          int[] temp = pairs[i];
          pairs[i] = pairs[j];
          pairs[j] = temp;
        }

      }
    }
    for (int i = 1; i < pairs.length; i++) {
      for (int j = 0; j < i; j++) {
        if (pairs[i][0] > pairs[j][1] && pairChainLength[i] < pairChainLength[j] + 1) {
          pairChainLength[i] = pairChainLength[j] + 1;
        }
      }
    }

    return Arrays.stream(pairChainLength).max().getAsInt();
  }


  @Test
  public void testMaxLength() {
    int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
    System.out.println(findLongestChain(pairs));

  }

  @Test
  public void testMaxLength2() {
    int[][] pairs = {{3, 4}, {2, 3}, {1, 2}};
    System.out.println(findLongestChain(pairs));

  }

  @Test
  public void testMaxLength3() {
    int[][] pairs = {{3, 4}, {2, 3}, {1, 2}};
    System.out.println(findLongestChain(pairs));

  }

  @Test
  public void testMaxLength4() {
    int[][] pairs = {{-10, -8}, {8, 9}, {-5, 0}, {6, 10}, {-6, -4}, {1, 7}, {9, 10}, {-4, 7}};
    System.out.println(findLongestChain(pairs));

  }

}
