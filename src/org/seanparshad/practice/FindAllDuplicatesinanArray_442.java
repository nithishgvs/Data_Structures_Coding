package org.seanparshad.practice;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinanArray_442 {

  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      int value = Math.abs(nums[i]) - 1;
      if (nums[value] < 0) {
        result.add(Math.abs(nums[i]));
      } else {
        nums[value] = -1 * nums[value];
      }
    }
    return result;
  }
}
