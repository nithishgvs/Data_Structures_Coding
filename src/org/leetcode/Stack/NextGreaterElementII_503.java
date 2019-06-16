package org.leetcode.Stack;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class NextGreaterElementII_503 {


  public class StackCustom {

    int val;
    int nextGreater;

    public StackCustom(int val, int nextGreater) {
      this.val = val;
      this.nextGreater = nextGreater;
    }
  }

  public int[] nextGreaterElements(int[] nums) {
    int[] out = new int[nums.length];

    Set<Integer> set=new HashSet<>();



    return new int[]{};
  }


  @Test
  public void testNextGreater() {
    nextGreaterElements(new int[]{1, 2, 1});
  }

}
