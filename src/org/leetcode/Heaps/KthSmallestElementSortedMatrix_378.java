package org.leetcode.Heaps;

import java.util.PriorityQueue;
import org.junit.Test;

public class KthSmallestElementSortedMatrix_378 {

  public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        priorityQueue.add(matrix[i][j]);
      }
    }
    int i = 1;
    while (i < k) {
      priorityQueue.poll();
      i++;
    }
    return priorityQueue.poll();
  }


  @Test
  public void testSmallestKth() {
    int[][] matrix = {
        {1, 5, 9},
        {10, 11, 13},
        {12, 13, 15}
    };
    System.out.println(kthSmallest(matrix, 8));
  }


}
