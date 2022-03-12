package org.twentytwentytwo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class SubsetsII_90 {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    Arrays.sort(nums);
    subsetHelper(0, new ArrayList<>(), result, nums);

    return result;
  }

  private void subsetHelper(int index, ArrayList<Integer> partialSubList, List<List<Integer>> result, int[] nums) {
    if (index == nums.length) {
      if (!result.contains(partialSubList))
        result.add(new ArrayList<>(partialSubList));
      return;
    }
    partialSubList.add(nums[index]);
    subsetHelper(index + 1, partialSubList, result, nums);
    partialSubList.remove(partialSubList.size()-1);
    subsetHelper(index + 1, partialSubList, result, nums);

  }

  @Test
  public void test1() {
    int[] nums = {4, 4, 4, 1, 4};
    subsetsWithDup(nums);
  }
}
