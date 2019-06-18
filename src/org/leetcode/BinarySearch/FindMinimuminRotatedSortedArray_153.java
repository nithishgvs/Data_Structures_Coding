package org.leetcode.BinarySearch;

import java.util.Arrays;
import org.junit.Test;

public class FindMinimuminRotatedSortedArray_153 {


  public int findMin(int[] nums) {

    int l = 0, h = nums.length - 1;

    while (l <= h) {
      if (l == h) {
        return nums[l];
      }
      int mid = (h - l) / 2 + l;
      if ((mid - 1 >= 0) && nums[mid] > nums[mid - 1] && (mid + 1 < nums.length) &&
          nums[mid] > nums[mid + 1]) {
        return nums[mid + 1];
      } else if (mid - 1 < 0 && mid + 1 < nums.length && nums[mid] < nums[mid + 1]) {
        return nums[mid];
      } else if ((mid - 1 >= 0) && nums[mid] < nums[mid - 1] && (mid + 1 < nums.length) &&
          nums[mid] < nums[mid + 1]) {
        return nums[mid];
      } else {
        int[] arr1 = Arrays.copyOfRange(nums, 0, mid);
        int[] arr2 = Arrays.copyOfRange(nums, mid + 1, nums.length);
        return Math.min(findMin(arr1), findMin(arr2));
      }

    }

    return Integer.MAX_VALUE;
  }


  @Test
  public void test1() {
    System.out.println(findMin(new int[]{4, 5, 6, 7, 8, 9, 10, 11, 1, 2}));
  }//4,5,6,7,0,1,2

  @Test
  public void test2() {
    System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
  }

  @Test
  public void test3() {
    System.out.println(findMin(new int[]{3, 1, 2}));
  }
}
