package org.leetcode.Bracktracking;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class Permutations_46 {


  public List<List<Integer>> permute(int[] nums) {

    List<List<Integer>> list = new ArrayList<>();

    permuteHelper(list, 0, nums.length - 1, nums);

    return list;

  }

  private void permuteHelper(List<List<Integer>> list, int l, int h, int[] nums) {

    if (l == h) {
      ArrayList<Integer> tempList = new ArrayList<>();
      for (int x : nums) {
        tempList.add(x);
      }
      list.add(tempList);
    }

    for (int i = l; i <= h; i++) {
      nums = swapIntegers(nums, i, l);
      permuteHelper(list, l + 1, h, nums);
      nums = swapIntegers(nums, i, l);
    }

  }

  private int[] swapIntegers(int[] nums, int i, int l) {
    int temp = nums[i];
    nums[i] = nums[l];
    nums[l] = temp;
    return nums;
  }

  @Test
  public void test1() {
    permute(new int[]{1, 2, 3}).forEach(l -> l.forEach(y -> System.out.println(y)));
  }


}
