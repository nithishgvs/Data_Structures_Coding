package org.neetcode.io.ArraysAndHashing;

import org.junit.Test;

public class ProductofArrayExceptSelf_238 {

  public int[] productExceptSelf(int[] nums) {

    int[] result = new int[nums.length];

    int[] prefix = new int[nums.length];
    prefix[0] = 1;
    int[] suffix = new int[nums.length];
    suffix[nums.length - 1] = 1;

    for (int i = 1; i < nums.length; i++) {
      prefix[i] = prefix[i - 1] * nums[i - 1];
    }

    for (int i = nums.length - 2; i > -1; i--) {
      suffix[i] = nums[i + 1] * suffix[i + 1];
    }

    for (int i = 0; i < result.length; i++) {
      result[i] = prefix[i] * suffix[i];
    }

    return result;

  }

  @Test
  public void test() {
    int[] nums = {1, 2, 3};
    System.out.println(productExceptSelf(nums));
  }

}
