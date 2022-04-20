package org.twentytwentytwo.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.junit.Test;

public class NextGreaterElementI_496 {


  public int[] nextGreaterElement(int[] nums1, int[] nums2) {

    Stack<Integer> stack = new Stack<>();
    Map<Integer, Integer> map = new HashMap<>();

    int[] result = new int[nums1.length];

    for (int i = 0; i < nums2.length; i++) {
      while (!stack.isEmpty() && stack.peek() < nums2[i]) {
        map.put(stack.pop(), nums2[i]);
      }
      stack.add(nums2[i]);
    }

    for (int i = 0; i < nums1.length; i++) {
      result[i] = map.getOrDefault(nums1[i], -1);
    }

    return result;
  }


  @Test
  public void test1() {
    //nums1 = [4,1,2], nums2 = [1,3,4,2]
    int[] nums1 = {4, 1, 2};
    int[] nums2 = {1, 3, 4, 2};
    nextGreaterElement(nums1, nums2);
  }
}
