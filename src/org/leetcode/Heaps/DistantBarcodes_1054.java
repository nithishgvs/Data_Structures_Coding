package org.leetcode.Heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Test;

public class DistantBarcodes_1054 {

  public int[] rearrangeBarcodes(int[] barcodes) {
    int[] output = new int[barcodes.length];

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < barcodes.length; i++) {
      map.put(barcodes[i], map.getOrDefault(barcodes[i], 0) + 1);
    }

    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      maxHeap.add(new int[]{entry.getKey(), entry.getValue()});
    }

    int i = 0;

    while (!maxHeap.isEmpty()) {
      int[] curr = maxHeap.poll();

      if (i > 0 && output[i - 1] == curr[0]) {
        int[] next = maxHeap.poll();
        output[i++] = next[0];
        next[1] = next[1] - 1;
        if (next[1] > 0) {
          maxHeap.add(next);
        }
        maxHeap.add(curr);

      } else {
        output[i++] = curr[0];
        curr[1] = curr[1] - 1;
        if (curr[1] > 0) {
          maxHeap.add(curr);
        }
      }
    }

    return output;

  }


  @Test
  public void test() {
    int[] barcodes = new int[]{1, 1, 1, 2, 2, 2};
    System.out.println(Arrays.toString(rearrangeBarcodes(barcodes)));
  }


  @Test
  public void test1() {
    int[] barcodes = new int[]{1, 1, 1, 1, 2, 2, 3, 3};
    System.out.println(Arrays.toString(rearrangeBarcodes(barcodes)));
  }
}
