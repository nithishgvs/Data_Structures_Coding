package org.leetcode.DynamicProgramming;

import java.util.Arrays;
import org.junit.Test;

public class StoneGame_877 {

  /**
   * worst question
   */
  public boolean stoneGame(int[] piles) {

    if (piles.length == 0) {
      return false;
    } else if (piles.length == 1) {
      return true;
    } else if (piles.length == 2) {
      return !(piles[0] != piles[1]);
    }

    boolean dp1Chance = true;
    boolean dp2Chance = true;
    int[] dp1 = new int[piles.length / 2];
    int[] dp2 = new int[piles.length / 2];

    int dp1Index = 0;
    int dp2Index = 0;

    while (dp1Index < dp1.length || dp2Index < dp2.length) {
      if (dp1Chance) {
        if (piles[0] >= piles[piles.length - 1]) {
          if (dp1Index - 1 >= 0) {
            dp1[dp1Index] = piles[0] + dp1[dp1Index - 1];
          } else {
            dp1[dp1Index] = piles[0];
          }
          piles = Arrays.copyOfRange(piles, 1, piles.length);
        } else {
          if (dp1Index - 1 >= 0) {
            dp1[dp1Index] = piles[piles.length - 1] + dp1[dp1Index - 1];
          } else {
            dp1[dp1Index] = piles[piles.length - 1];
          }
          piles = Arrays.copyOfRange(piles, 0, piles.length - 1);
        }
        dp1Index++;
        dp1Chance = false;
        dp2Chance = true;
      }

      if (dp2Chance) {
        if (piles[0] <= piles[piles.length - 1]) {
          if (dp2Index - 1 >= 0) {
            dp2[dp2Index] = piles[0] + dp2[dp2Index - 1];
          } else {
            dp2[dp2Index] = piles[0];
          }
          piles = Arrays.copyOfRange(piles, 1, piles.length);
        } else {
          if (dp2Index - 1 >= 0) {
            dp2[dp2Index] = piles[piles.length - 1] + dp2[dp2Index - 1];
          } else {
            dp2[dp2Index] = piles[piles.length - 1];
          }
          piles = Arrays.copyOfRange(piles, 0, piles.length - 1);
        }
        dp2Index++;
        dp1Chance = true;
        dp2Chance = false;
      }
    }

    return dp1[dp1.length - 1] > dp2[dp2.length - 1];
  }


  public boolean stoneGame1(int[] piles) {
    int alex = 0;
    int lee = 0;
    for (int i = 0; i < piles.length / 2; i++) {
      alex = alex + Math.max(piles[i], piles[piles.length - i - 1]);
      lee = lee + Math.min(piles[i], piles[piles.length - i - 1]);
    }
    return alex > lee;
  }


  @Test
  public void test1() {
    System.out.println(stoneGame(new int[]{5, 3, 4, 5}));
  }

  @Test
  public void test2() {
    System.out.println(stoneGame(new int[]{3, 7, 2, 3}));
  }
}
