package org.practice.io.ArraysAndHashing;

import org.junit.Test;

public class SortArrayByParity_905 {

  public int[] sortArrayByParity(int[] nums) {

    boolean oddFound = false;
    boolean evenFound = false;

    int start = 0;

    int end = nums.length - 1;

    while (start <= end) {

      if (nums[start] % 2 == 1) {
        oddFound = true;
      } else {
        start++;
      }

      if (nums[end] % 2 == 0) {
        evenFound = true;
      } else {
        end--;
      }

      if (oddFound && evenFound) {
        oddFound = false;
        evenFound = false;
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
      }


    }

    return nums;

  }

  @Test
  public void test() {
    sortArrayByParity(new int[]{2,2,1,1});
  }

}
