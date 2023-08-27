package org.practice.io.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class CombinationSum_39 {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> combinations = new ArrayList<>();
    Arrays.sort(candidates);
    generateCombinations(0, new ArrayList<>(), candidates, target, combinations);
    return combinations;
  }

  private void generateCombinations(int startIndex, List<Integer> currentCandidates,
      int[] candidates, int target, List<List<Integer>> combinations) {
    if (target == 0) {
      combinations.add(new ArrayList<>(currentCandidates));
      return;
    }

    for (int i = startIndex; i < candidates.length; i++) {
      if (candidates[startIndex] <= target) {
        currentCandidates.add(candidates[startIndex]);
        generateCombinations(startIndex, currentCandidates, candidates,
            target - candidates[startIndex], combinations);
        currentCandidates.remove(currentCandidates.size() - 1);
        ++startIndex;
      }

    }

  }


  @Test
  public void test1() {
    combinationSum(new int[]{2}, 1);
  }

}
