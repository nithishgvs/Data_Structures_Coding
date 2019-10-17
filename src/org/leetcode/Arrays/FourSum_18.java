package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class FourSum_18 {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> fourSumList = new ArrayList<>();

    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        List<List<Integer>> list = twoSum(j + 1, nums.length - 1, nums,
            target - (nums[i] + nums[j]));
        if (list != null) {
          for (List<Integer> l : list) {
            List<Integer> output = new ArrayList<>();
            output.add(nums[i]);
            output.add(nums[j]);
            output.addAll(l);
            if (!fourSumList.contains(output)) {
              fourSumList.add(output);
            }
          }

        }
      }
    }

    return fourSumList;

  }


  private List<List<Integer>> twoSum(int l, int h, int[] nums, int sum) {
    List<List<Integer>> list = null;

    while (l < h) {
      if (nums[l] + nums[h] == sum) {
        if (list == null) {
          list = new ArrayList<>();
        }
        List<Integer> smallList = new ArrayList<>();
        smallList.add(nums[l]);
        smallList.add(nums[h]);
        list.add(smallList);
        l++;
        h--;
        continue;
      }

      if (nums[l] + nums[h] < sum) {
        l++;
      } else {
        h--;
      }
    }

    return list;
  }


  @Test
  public void foursumTest() {
    int[] nums = {1, 0, -1, 0, -2, 2};
    fourSum(nums, 0);
  }

  @Test
  public void foursumTest2() {
    int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3, 0};
    fourSum(nums, 0);
  }

  //-4,-3,-2,-1,0,0,1,2,3,4
  @Test
  public void foursumTest3() {
    int[] nums = {-4, -3, -2, -1, 0, 0, 1, 2, 3, 4};
    fourSum(nums, 0);
  }

}
