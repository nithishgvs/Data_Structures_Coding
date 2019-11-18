package org.leetcode.Arrays;

import org.junit.Test;

public class CheckIfItIsaStraightLine_1232 {


  public boolean checkStraightLine(int[][] coordinates) {

    int slope = 0;

    for (int i = 1; i < coordinates.length; i++) {

      int currentSlope = (coordinates[i][1] - coordinates[i
          - 1][1]) / (coordinates[i][0] - coordinates[i
          - 1][0]);

      if (i == 1) {
        slope = currentSlope;
      } else {
        if (currentSlope != slope) {
          return false;
        }
      }
    }

    return true;

  }


  @Test
  public void test() {
    int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
    System.out.println(checkStraightLine(coordinates));

  }

  @Test
  public void test1() {
    int[][] coordinates = {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
    System.out.println(checkStraightLine(coordinates));

  }


  @Test
  public void test3() {
    int[][] coordinates = {{-3, -2}, {-1, -2}, {2, -2}, {-2, -2}, {0, -2}};
    System.out.println(checkStraightLine(coordinates));

  }
}
