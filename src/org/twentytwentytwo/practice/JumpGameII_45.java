package org.twentytwentytwo.practice;

import java.util.Arrays;
import org.junit.Test;

public class JumpGameII_45 {

  public int jump(int[] nums) {

    int[] dp = new int[nums.length];
    Arrays.fill(dp, nums.length + 1);
    dp[0] = 0;

    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] + j >= i) {
          dp[i] = Math.min(dp[i], 1 + dp[j]);
          break;
        }
      }
    }

    return dp[nums.length - 1];

  }


  @Test
  public void test() {
    int[] nums = {2, 3, 0, 1, 4};
    System.out.println(jump(nums));
  }
}
