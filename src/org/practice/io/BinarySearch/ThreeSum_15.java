package org.practice.io.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class ThreeSum_15 {

  public List<List<Integer>> threeSum(int[] nums) {

    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {

      if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

        int low = i + 1;
        int high = nums.length - 1;

        int sum = 0 - nums[i];
        while (low < high) {
          if (nums[low] + nums[high] == sum) {
            result.add(Arrays.asList(nums[i], nums[low], nums[high]));
            while (low < high && nums[low] == nums[low + 1]) {
              low++;
            }
            while (low < high && nums[high] == nums[high - 1]) {
              high--;
            }
            low++;
            high--;
          } else if (nums[low] + nums[high] > sum) {
            high--;
          } else {
            low++;
          }
        }

      }

    }

    return result;
  }


  @Test
  public void test() {
    threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    threeSum(new int[]{0, 0, 0});
  }

}
