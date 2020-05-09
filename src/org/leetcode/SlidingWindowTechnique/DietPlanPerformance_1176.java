package org.leetcode.SlidingWindowTechnique;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class DietPlanPerformance_1176 {

  public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
    Integer score = 0;

    int start = 0, end = 0;

    int currentSum = 0;

    Map<Integer, Integer> sumMap = new HashMap<>();

    while (end <= calories.length - 1) {

      currentSum += calories[end];

      if (end - start + 1 == k) {
        if (!sumMap.containsKey(start - 1)) {
          int sum = currentSum;
          if (sum > upper) {
            score++;
          } else if (sum < lower) {
            score--;
          }

        } else {
          int sum = currentSum - sumMap.get(start - 1);
          if (sum > upper) {
            score++;
          } else if (sum < lower) {
            score--;
          }
        }
        start++;
      }

      sumMap.put(end, currentSum);
      end++;
    }

    return score;
  }


  @Test
  public void test1() {
    //System.out.println(dietPlanPerformance(new int[]{6, 5, 0, 0, 7, 5, 4, 3, 9}, 2, 1, 5));
    //System.out.println(dietPlanPerformance(new int[]{1,2,3,4,5}, 1, 3, 3));
    System.out.println(dietPlanPerformance(new int[]{3, 2}, 2, 0, 1));
  }


}
