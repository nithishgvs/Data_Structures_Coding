package org.twentytwentytwo.practice;

import java.util.Arrays;

public class ProductofArrayExceptSelf_238 {

  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];

    Arrays.fill(result, 1);

    int[] prefixArray = new int[nums.length];
    int[] suffixArray = new int[nums.length];

    prefixArray[0] = nums[0];
    suffixArray[nums.length - 1] = nums[nums.length - 1];

    for (int i = 1; i < nums.length; i++) {
      prefixArray[i] = nums[i] * prefixArray[i - 1];
    }

    for (int i = nums.length - 2; i > -1; i--) {
      suffixArray[i] = nums[i] * suffixArray[i + 1];
    }

    for (int i = 0; i < nums.length; i++) {
      if (i - 1 > -1) {
        result[i] *= prefixArray[i - 1];
      }
      if (i + 1 < nums.length) {
        result[i] *= suffixArray[i + 1];
      }
    }

    return result;
  }


}
