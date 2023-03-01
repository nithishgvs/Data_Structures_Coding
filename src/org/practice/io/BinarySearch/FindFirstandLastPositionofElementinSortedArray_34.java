package org.practice.io.BinarySearch;

import org.junit.Test;

public class FindFirstandLastPositionofElementinSortedArray_34 {


  public int[] searchRange(int[] nums, int target) {
    return binarySearch(nums, target, 0, nums.length - 1);
  }

  private int[] binarySearch(int[] nums, int target, int l, int h) {

    int[] result = {-1, -1};

    while (l <= h) {
      int mid = l + (h - l) / 2;
      if (nums[mid] == target) {
        result[0] = helper(nums, target, true, l, mid - 1, mid);
        result[1] = helper(nums, target, false, mid + 1, h, mid);
        break;
      }
      if (nums[mid] > target) {
        h = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return result;

  }

  private int helper(int[] nums, int target, boolean fromLeft, int l, int h, int foundIndex) {
    while (l <= h) {
      int mid = l + (h - l) / 2;
      if (nums[mid] == target) {
        if (fromLeft) {
          return helper(nums, target, fromLeft, l, mid - 1, mid);
        } else {
          return helper(nums, target, fromLeft, mid + 1, h, mid);
        }
      }
      if (nums[mid] > target) {
        h = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return foundIndex;
  }


  @Test
  public void test() {
    //searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
    searchRange(new int[]{1,1,1,1,1,1,1}, 1);
  }

}
