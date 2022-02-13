package org.seanparshad.practice;

public class SearchinRotatedSortedArray_33 {

  public int search(int[] nums, int target) {
    return binarySearch(nums, target, 0, nums.length - 1);
  }


  private int binarySearch(int[] nums, int target, int l, int h) {

    while (l <= h) {
      int mid = (h + l) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] >= nums[l]) {

        if (target >= nums[l] && target < nums[mid]) {
          h = mid - 1;
        } else {
          l = mid + 1;
        }

      } else {
        if (target > nums[mid] && target <= nums[h]) {
          l = mid + 1;
        } else {
          h = mid - 1;
        }
      }

    }
    return -1;
  }
}
