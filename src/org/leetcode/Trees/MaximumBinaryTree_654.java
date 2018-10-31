package org.leetcode.Trees;

import org.junit.Test;

public class MaximumBinaryTree_654 {


  public int maxElementIndex(int[] array, int l, int h) {
    int maxIndex = l;

    int maxElement = array[l];

    for (int i = l + 1; i <= h; i++) {
      if (array[i] > maxElement) {
        maxElement = array[i];
        maxIndex = i;
      }
    }
    return maxIndex;
  }


  @Test
  public void testTree() {
    int[] array = {1, 6, 0, 1, 2, 16};
    System.out.println(maxElementIndex(array, 0, array.length - 1));
  }

}
