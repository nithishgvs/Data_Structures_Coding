package org.practice.io.ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class LongestConsecutiveSequence_128 {


  public int longestConsecutive(int[] nums) {
    if(nums.length==0){
      return 0;
    }
    int longestResult = 1;

    Set<Integer> set = new HashSet<>();

    for (int n : nums) {
      set.add(n);
    }

    for (int n : nums) {

      if (set.contains(n - 1)) {
        continue;
      }
      int tempMax = 1;

      while (set.contains(n + 1)) {
        tempMax++;
        longestResult = Math.max(longestResult, tempMax);
        n = n + 1;
      }
    }

    return longestResult;
  }


  @Test
  public void test1() {
    int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    int[] nums1 = {100,4,200,1,3,2};
    System.out.println(longestConsecutive(nums1));
  }

}
