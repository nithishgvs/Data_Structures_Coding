package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class CombinationSum_39 {


  List<List<Integer>> outputList = new ArrayList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {

    if (candidates.length == 0) {
      return new ArrayList<>();
    }
    Arrays.sort(candidates);
    helperSum(candidates, 0, target, new ArrayList<Integer>());
    return outputList;
  }

  private void helperSum(int[] candidates, int i, int target,
      ArrayList<Integer> partialList) {
    if (target == 0) {
      outputList.add(partialList);
      return;
    }
    for (int j = i; j < candidates.length; j++) {
      if (candidates[i] > target) {
        break;
      }
      //With the number
      ArrayList<Integer> newList = new ArrayList<>(partialList);
      newList.add(candidates[j]);
      helperSum(candidates, j, target - candidates[j], newList);
    }
  }

  @Test
  public void test1() {
    System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
  }

  @Test
  public void test2() {
    System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
  }

}
