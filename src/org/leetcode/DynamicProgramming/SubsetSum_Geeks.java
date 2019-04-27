package org.leetcode.DynamicProgramming;

import org.junit.Test;

//https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
public class SubsetSum_Geeks {

  public boolean isSubsetSum(int set[],
      int sum) {

    boolean[][] subsetMatrix = new boolean[set.length][sum + 1];

    for (int i = 0; i < set.length; i++) {
      subsetMatrix[i][0] = true;
    }

    for (int i = 0; i < set.length; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (set[i] > j) {
          if (i > 0) {
            subsetMatrix[i][j] = subsetMatrix[i - 1][j];
          }
        } else {
          if (i > 0) {
            if (subsetMatrix[i - 1][j] == true) {
              subsetMatrix[i][j] = true;

            } else {
              subsetMatrix[i][j] = subsetMatrix[i - 1][j - set[i]];
            }
          } else {
            if (set[i] == j) {
              subsetMatrix[i][j] = true;
            }
          }
        }
      }
    }

    return subsetMatrix[set.length - 1][sum];
  }


  @Test
  public void testIsSubsetSum() {
    int set[] = {2, 3, 7, 8, 10};
    int sum = 11;
    System.out.println(isSubsetSum(set, sum));
  }


}
