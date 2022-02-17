package org.twentytwentytwo.practice;

public class SingleElementInASortedArray_540 {

  public int singleNonDuplicate(int[] nums) {
    return binarySearch(nums, 0, nums.length - 1);
  }

  private int binarySearch(int[] nums, int l, int h) {

    while (l < h) {

      int mid = l + (h - l) / 2;
      boolean isEven = (h - mid) % 2 == 0;
      if (nums[mid] == nums[mid - 1]) {
        if (isEven) {
          h = mid - 2;
        } else {
          l = mid + 1;
        }
      } else if (nums[mid] == nums[mid + 1]) {
        if (isEven) {
          l = mid + 2;
        } else {
          h = mid - 1;
        }
      } else {
        return nums[mid];
      }


    }

    return nums[l];
  }
}
