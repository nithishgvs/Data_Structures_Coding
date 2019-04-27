package org.leetcode.Arrays;

import java.util.Arrays;
import org.junit.Test;

public class SortColors_75 {

  //Looks like Dutch national flag problem


  public void sortColors(int[] nums) {

    if(nums.length<1){
      return;
    }

    System.out.println(Arrays.toString(nums));

    int l = 0, h = nums.length - 1;
    int mid = 0;

    while (mid <= h) {
      switch (nums[mid]) {
        case 0:
          swapElements(nums, mid, l);
          l++;
          mid++;
          break;
        case 1:
          mid++;
          break;
        case 2:
          swapElements(nums, mid, h);
          h--;
          break;

      }
    }

    System.out.println(Arrays.toString(nums));

  }

  private void swapElements(int[] nums, int l, int h) {
    int temp=nums[l];
    nums[l]=nums[h];
    nums[h]=temp;
  }


  @Test
  public void testSortColors1() {
    int[] nums = {2, 0, 2, 1, 1, 0};
    sortColors(nums);
  }

  @Test
  public void testSortColors2() {
    int[] nums = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
    sortColors(nums);
  }


}
