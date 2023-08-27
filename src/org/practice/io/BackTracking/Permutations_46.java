package org.practice.io.BackTracking;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class Permutations_46 {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> allPermutations = new ArrayList<>();
    generateAllPermutations(new ArrayList<>(), allPermutations, nums);
    return allPermutations;
  }

  private void generateAllPermutations(ArrayList<Integer> currentPermutation,
      List<List<Integer>> allPermutations, int[] nums) {

    if (currentPermutation.size() == nums.length) {
      allPermutations.add(new ArrayList<>(currentPermutation));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (currentPermutation.contains(nums[i])) {
        continue;
      }

      currentPermutation.add(nums[i]);
      generateAllPermutations(currentPermutation, allPermutations, nums);
      currentPermutation.remove(currentPermutation.size() - 1);
    }
  }

  @Test
  public void test(){
    permute(new int[]{1,2,3});
  }


}
