package org.lcfresh.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

//Prefer Binary Search for finding Element
public class ThreeSum_15 {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    if (nums.length == 0 || nums.length < 3) {
      return list;
    }

    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int foundNum = binarySearch(j + 1, nums.length - 1, 0 - (nums[i] + nums[j]), nums);
        if (foundNum != Integer.MIN_VALUE) {
          List<Integer> al = new ArrayList<>();
          al.add(nums[i]);
          al.add(nums[j]);
          al.add(foundNum);
          if (!list.contains(al)) {
            list.add(al);
          }
        }
      }
    }

    return list;
  }

  public int binarySearch(int l, int h, int elem, int[] nums) {
    while (l <= h) {
      int mid = (h - l) / 2 + l;
      if (elem == nums[mid]) {
        return elem;
      } else if (nums[mid] < elem) {
        l = mid + 1;
      } else {
        h = mid - 1;
      }
    }
    return Integer.MIN_VALUE;
  }

  @Test
  public void test1() {
    System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
  }

  @Test
  public void test2() {
    System.out.println(threeSum(new int[]{0, 0, 0, 0}));
  }

  @Test
  public void test3() {
    System.out.println(threeSum(new int[]{-2, 0, 1, 1, 2}));
  }

}
