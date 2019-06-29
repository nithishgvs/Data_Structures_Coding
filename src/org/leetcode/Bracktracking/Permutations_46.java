package org.leetcode.Bracktracking;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class Permutations_46 {


  List<List<Integer>> finalList = new ArrayList<>();

  public List<List<Integer>> permute(int[] nums) {

    permuteHelper(nums, 0);
    return finalList;
  }

  private void permuteHelper(int[] nums, int i) {
    if (nums.length == 0 || i >= nums.length) {
      return;
    }

    if (i == nums.length - 1) {
      ArrayList<Integer> list = new ArrayList<>();
      for (int x : nums) {
        list.add(x);
      }
      finalList.add(list);
    }

    for (int k = i; k < nums.length; k++) {
      swapNums(nums, k, i);
      permuteHelper(nums, i + 1);
      swapNums(nums, k, i);
    }
  }

  public void swapNums(int[] nums, int i, int j) {
    int x = nums[i];
    nums[i] = nums[j];
    nums[j] = x;
  }

  @Test
  public void test1() {
    permute(new int[]{1, 2, 3}).forEach(l -> l.forEach(y -> System.out.println(y)));
  }


}
