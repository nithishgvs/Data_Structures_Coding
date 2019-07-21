package org.leetcode.DepthFirstSearch;

import java.util.Arrays;
import org.junit.Test;

public class PartitiontoKEqualSumSubsets_698 {

  boolean[] visited;

  public boolean canPartitionKSubsets1(int[] nums, int k) {
    Arrays.sort(nums);
    visited = new boolean[nums.length];

    int sum = Arrays.stream(nums).sum();

    int target = sum / k;

    if (nums.length == 0 || sum % k != 0 || nums[nums.length - 1] > target) {
      return false;
    }

    return canPartitionHelper1(nums.length - 1, 0, 0, target, nums, visited, k);
  }


  public boolean canPartitionHelper1(int endIndex, int startIndex, int currentSum, int targetSum,
      int[] nums, boolean[] visited, int k) {
    if (k == 1) {
      return true;
    }

    if (currentSum == targetSum) {
      return canPartitionHelper1(endIndex - 1, 0, 0, targetSum, nums, visited, --k);
    }

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[endIndex] == targetSum) {
        visited[endIndex] = true;
        endIndex = endIndex - 1;
        return canPartitionHelper1(endIndex, 0, 0, targetSum, nums, visited, --k);
      } else if (!visited[endIndex] && !visited[i] && nums[endIndex] + nums[i] <= targetSum) {
        visited[endIndex] = true;
        visited[i] = true;
        if (canPartitionHelper1(endIndex, 0, nums[endIndex] + currentSum + nums[i], targetSum, nums,
            visited,
            k)) {
          return true;
        } else {
          visited[i] = false;
        }
      }

    }

    return false;

  }


  public boolean canPartitionKSubsets(int[] nums, int k) {

    visited = new boolean[nums.length];

    int sum = Arrays.stream(nums).sum();

    int target = sum / k;

    if (nums.length == 0 || sum % k != 0 || nums[nums.length - 1] > target) {
      return false;
    }

    return canPartitionHelper(0, 0, target, nums, visited, k);

  }


  private boolean canPartitionHelper(int index, int currentSum, int targetSum, int[] nums,
      boolean[] visited, int k) {

    if (k == 1) {
      return true;
    }

    if (currentSum == targetSum) {
      return canPartitionHelper(0, 0, targetSum, nums, visited, --k);
    }
    for (int i = index; i < nums.length; i++) {
      if (!visited[i] && currentSum + nums[i] <= targetSum) {
        visited[i] = true;
        if (canPartitionHelper(i + 1, currentSum + nums[i], targetSum, nums, visited, k)) {
          return true;
        }
        visited[i] = false;
      }
    }

    return false;
  }

  @Test
  public void test1() {
    System.out.println(canPartitionKSubsets1(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
  }

  @Test
  public void test2() {
    System.out.println(canPartitionKSubsets(new int[]{1, 2, 3, 4}, 3));
  }


  @Test
  public void test3() {
    System.out
        .println(
            canPartitionKSubsets(new int[]{10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6, 6}, 3));
  }

  @Test
  public void test4() {
    System.out
        .println(
            canPartitionKSubsets(new int[]{2, 2, 2, 2, 3, 4, 5}, 4));
  }

  @Test
  public void test5() {
    System.out
        .println(
            canPartitionKSubsets(new int[]{1, 2, 2, 3, 3, 4, 5}, 4));
  }
}
