package org.twentytwentytwo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class MaximumLengthofaConcatenatedStringwithUniqueCharacters_1239 {

  int maxLength = 0;

  public int maxLength(List<String> arr) {

    helper(arr, 0, new ArrayList<>());

    return maxLength;

  }

  private void helper(List<String> arr, int index, List<String> partialList) {

    if (index == arr.size()) {
      maxLength = Math.max(maxLength, duplicatesRemoval(partialList));
      return;
    }

    partialList.add(arr.get(index));
    helper(arr, index + 1, partialList);
    partialList.remove(partialList.size() - 1);
    helper(arr, index + 1, partialList);
  }

  private int duplicatesRemoval(List<String> partialList) {
    Set<Character> set = new HashSet<>();
    for (String list : partialList) {
      for (char ch : list.toCharArray()) {
        if (!set.add(ch)) {
          return 0;
        }
      }
    }
    return set.size();
  }

  @Test
  public void test1() {
    List<String> arr = Arrays.asList("un", "iq", "ue");
    System.out.println(maxLength(arr));
  }

}
