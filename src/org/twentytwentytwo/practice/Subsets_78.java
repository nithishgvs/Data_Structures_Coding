package org.twentytwentytwo.practice;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {

  public List<List<Integer>> subsets(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();

    subsetHelper(0, new ArrayList<>(), result, nums);

    return result;
  }

  private void subsetHelper(int index, ArrayList<Integer> partialSubList,
      List<List<Integer>> result, int[] nums) {
    if (index == nums.length) {
      result.add(new ArrayList<>(partialSubList));
      return;
    }
    partialSubList.add(nums[index]);
    subsetHelper(index + 1, partialSubList, result, nums);
    partialSubList.remove(partialSubList.size() - 1);
    subsetHelper(index + 1, partialSubList, result, nums);

  }
}
