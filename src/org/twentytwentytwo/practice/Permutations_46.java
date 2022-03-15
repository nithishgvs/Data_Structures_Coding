package org.twentytwentytwo.practice;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {

  public List<List<Integer>> permute(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();

    generatePermutations(nums, result, new ArrayList());

    return result;

  }

  private void generatePermutations(int[] nums, List<List<Integer>> result,
      List<Integer> currentChoices) {
    if (currentChoices.size() == nums.length) {
      result.add(new ArrayList<>(currentChoices));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      int current = nums[i];
      if (currentChoices.contains(current)) {
        continue;
      }
      currentChoices.add(current);
      generatePermutations(nums, result, currentChoices);
      currentChoices.remove(currentChoices.size() - 1);
    }

  }
}
