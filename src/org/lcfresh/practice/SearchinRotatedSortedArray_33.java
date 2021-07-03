package org.lcfresh.practice;

import org.junit.Test;

public class SearchinRotatedSortedArray_33 {


  public int search(int[] nums, int target) {


    if(nums.length==1){
      if(nums[0]==target){
        return 0;
      }else{
        return -1;
      }
    }

    int pivot = findPivot(nums);

    if (pivot == -1) {
      return binarySearch(nums, 0, nums.length - 1, target);
    }

    if (nums[0] > target) {
      return binarySearch(nums, pivot, nums.length - 1, target);
    } else {
      return binarySearch(nums, 0, pivot - 1, target);
    }

  }

  private int binarySearch(int[] nums, int l, int h, int target) {

    while (l <= h) {
      int mid = (h - l) / 2 + l;

      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        l = mid + 1;
      } else {
        h = mid - 1;
      }
    }

    return -1;
  }

  private int findPivot(int[] nums) {

    int l = 0, h = nums.length - 1;

    while (l <= h) {
      int mid = (h - l) / 2 + l;
      if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
        return mid + 1;
      }
      if (nums[mid] >= nums[l]) {
        l = mid + 1;
      } else {
        h = mid - 1;
      }

    }

    return -1;
  }

  @Test
  public void test6() {
    System.out.println(search(new int[]{1,3}, 0));
  }

}
