package org.leetcode.Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import org.junit.Test;

public class ContiguousArray_525 {


  public int findMaxLength(int[] nums) {
    if (nums.length < 2) {
      return 0;
    }
    int maxLength = 0;

    Map<Integer, int[]> countMap = new HashMap<>();

    TreeSet<Integer> oneSet = new TreeSet<>();
    TreeSet<Integer> zeroSet = new TreeSet<>();

    for (int i = 0; i < nums.length; i++) {

      int val = nums[i];

      if (countMap.containsKey(i - 1)) {
        int[] intArray = countMap.get(i - 1);
        int[] newArray = new int[2];
        if (val == 0) {
          newArray[0] = intArray[0] + 1;
          newArray[1] = intArray[1];
        } else {
          newArray[0] = intArray[0];
          newArray[1] = intArray[1] + 1;
        }

        if (newArray[0] != 0 && newArray[1] != 0) {

        }

        countMap.put(i, newArray);

      } else {
        if (val == 0) {
          int[] intArray = new int[]{1, 0};
          countMap.put(i, intArray);
        } else {
          int[] intArray = new int[]{0, 1};
          countMap.put(i, intArray);
        }

      }

    }

    return maxLength;
  }


  @Test
  public void test1() {
    System.out.println(findMaxLength(new int[]{0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0}));
  }

}
