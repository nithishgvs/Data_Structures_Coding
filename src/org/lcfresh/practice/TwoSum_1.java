package org.lcfresh.practice;

import java.util.Arrays;
import org.junit.Test;

public class TwoSum_1 {


  public int[] twoSum(int[] nums, int target) {

    Arrays.sort(nums);
    int[] result = new int[2];
    int l = 0, h = nums.length - 1;

    while (l < h) {
      int val1 = nums[l];
      int val2 = nums[h];

      if (val1 + val2 < target) {
        l++;
      } else if (val1 + val2 > target) {
        h--;
      }else{
        result[0]=val1;
        result[1]=val2;
        break;
      }
    }

    return result;
  }

  @Test
  public void testTwoSum() {
    int[] array = { 2, 5, 7, 8, 9, 3, 1, 16 };
    int target = 13;
    int[] twoSum = twoSum(array, target);
    System.out.println(Arrays.toString(twoSum));
  }

}
