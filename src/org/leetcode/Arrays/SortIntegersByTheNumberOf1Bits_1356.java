package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import org.junit.Test;

public class SortIntegersByTheNumberOf1Bits_1356 {

  public int[] sortByBits(int[] arr) {
    int[] result = new int[arr.length];
    int index = 0;
    List<int[]> list = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      list.add(new int[]{arr[i], Integer.bitCount(arr[i])});
    }
    PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> {
      if (a[1] == b[1]) {
        return a[0] - b[0];
      }
      return a[1] - b[1];
    });

    minheap.addAll(list);

    while (!minheap.isEmpty()) {
      result[index++] = minheap.poll()[0];
    }

    return result;
  }


  @Test
  public void test() {
    int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    int[] arr2 = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
    int[] arr3 = {10000, 10000};
    sortByBits(arr3);
  }
}
