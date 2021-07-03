package org.lcfresh.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementSortedMatrix_378 {


  public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    for (int[] sub : matrix) {
      for (int i = 0; i < sub.length; i++) {
        maxHeap.add(sub[i]);
      }
    }
    while (maxHeap.size() - k != 0) {
      maxHeap.poll();
    }

    return maxHeap.peek();

  }
}
