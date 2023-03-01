package org.practice.io.ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class ContainsDuplicate_217 {

  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (!set.add(num)) {
        return true;
      }
    }
    return false;
  }

  @Test
  public void test1() {
    int[] nums = {1, 2, 3, 4};
    System.out.println(containsDuplicate(nums));
  }


}
