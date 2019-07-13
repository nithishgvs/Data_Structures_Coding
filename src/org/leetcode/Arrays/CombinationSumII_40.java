package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class CombinationSumII_40 {

  List<List<Integer>> outputList = new ArrayList<>();

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    if (candidates.length == 0) {
      return new ArrayList<>();
    }

    helperSum(candidates, 0, target, new ArrayList<Integer>());
    return outputList;
  }

  private void helperSum(int[] candidates, int i, int target,
      ArrayList<Integer> partialList) {
    if (target == 0 && !outputList.contains(partialList)) {
      outputList.add(partialList);
      return;
    }
    for (int j = i; j < candidates.length; j++) {
      if (candidates[i] > target) {
        i++;
        continue;
      }
      //With the number
      ArrayList<Integer> newList = new ArrayList<>(partialList);
      newList.add(candidates[j]);
      Collections.sort(newList);
      helperSum(candidates, j + 1, target - candidates[j], newList);
    }
  }

  @Test
  public void test1() {
    System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
  }


}
