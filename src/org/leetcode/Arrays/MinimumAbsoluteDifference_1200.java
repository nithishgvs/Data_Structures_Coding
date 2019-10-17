package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class MinimumAbsoluteDifference_1200 {


  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    List<List<Integer>> output = new ArrayList<>();

    if (arr.length < 2) {
      return output;
    }

    Arrays.sort(arr);

    int minDiff = Integer.MAX_VALUE;

    Set<Integer> set = new HashSet<>();

    int prev = arr[0];
    set.add(arr[0]);

    for (int i = 1; i < arr.length; i++) {
      int curr = arr[i];
      set.add(curr);
      minDiff = Math.min(minDiff, curr - prev);
      prev = curr;
    }

    for (int i = 0; i < arr.length; i++) {
      if (set.contains(arr[i] + minDiff)) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[i]);
        list.add(arr[i] + minDiff);
        output.add(list);
      }
    }

    return output;

  }


  @Test
  public void test1(){
    int [] arr={3,8,-10,23,19,-4,-14,27};
    minimumAbsDifference(arr);
  }
}
