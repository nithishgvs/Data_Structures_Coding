package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SubSets_78 {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> outputList = new ArrayList<>();
    outputList.add(new ArrayList<>());
    for (int i = 0; i < nums.length; i++) {
      int tempSize = outputList.size();
      for (int j = 0; j < tempSize; j++) {
        List<Integer> tempList = new ArrayList<>(outputList.get(j));
        tempList.add(nums[i]);
        outputList.add(tempList);
      }
    }
    return outputList;
  }

}
