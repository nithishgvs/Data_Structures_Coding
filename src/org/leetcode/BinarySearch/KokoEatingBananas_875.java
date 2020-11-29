package org.leetcode.BinarySearch;

import org.junit.Test;

public class KokoEatingBananas_875 {

  //Checked solution but worth it
  public int minEatingSpeed(int[] piles, int H) {
    int min = 1;
    int max = -1;

    for (int pile : piles) {
      max = Math.max(max, pile);
    }
    while (min < max) {
      int bananasCanEat = min + (max - min) / 2;
      if (canEatBananas(bananasCanEat, piles, H)) {
        max = bananasCanEat;
      } else {
        min = bananasCanEat + 1;
      }
    }
    return min;
  }

  private boolean canEatBananas(int bananasCanEat, int[] piles, int H) {
    int hour = 0;

    for (int i = 0; i < piles.length; i++) {
      hour += piles[i] / bananasCanEat;
      if (piles[i] % bananasCanEat != 0) {
        hour++;
      }
    }
    return hour <= H;
  }

  @Test
  public void test() {
    System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
  }

}
