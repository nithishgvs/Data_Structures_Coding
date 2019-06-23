package org.leetcode.BinarySearch;

import java.util.Arrays;
import org.junit.Test;

public class FindFirstandLastPositionofElementinSortedArray_34 {


  public int[] searchRange(int[] nums, int target) {
    int arr[] = new int[]{-1, -1};
    if (nums.length == 0) {
      return arr;
    }
    if (nums.length == 1 && target == nums[0]) {
      arr[0] = 0;
      arr[1]=0;
      return arr;
    }
    int l = 0, h = nums.length - 1;
    while (l <= h) {
      int mid = (h - l) / 2 + l;
      if (nums[mid] == target) {
        arr[0] = searchHelper(nums, l, mid, target, false);
        arr[1] = searchHelper(nums, mid + 1, h, target, true);
        break;
      } else if (nums[mid] < target) {
        l = mid + 1;
      } else {
        h = mid - 1;
      }
    }
    return arr;
  }

  private int searchHelper(int[] nums, int l, int h, int target, boolean leftSearch) {
    while (l <= h) {
      int mid = (h - l) / 2 + l;
      if (nums[mid] == target) {
        if (!leftSearch) {
          h = mid - 1;
        } else {
          l = mid + 1;
        }
      } else if (nums[mid] < target) {
        l = mid + 1;
      } else {
        h = mid - 1;
      }
    }

    return !leftSearch ? l : h;
  }

  @Test
  public void test1() {
    searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
  }

  @Test
  public void test2() {
    Arrays.toString(searchRange(new int[]{1}, 1));
  }
  //1,2,3,3,3,3,4,5,9

  @Test
  public void test3() {
    searchRange(new int[]{1, 2, 3, 3, 3, 3, 4, 5, 9}, 3);
  }

}
