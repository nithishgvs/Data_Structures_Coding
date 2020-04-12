package org.leetcode.Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import org.junit.Test;

public class IntervalListIntersections_986 {

  public int[][] intervalIntersection(int[][] A, int[][] B) {

    if (A.length == 0 || B.length == 0) {
      return new int[0][0];
    }

    List<int[]> list = new ArrayList<>();

    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] ints1, int[] ints2) {
        if (ints1[0] != ints2[0]) {
          return ints1[0] - ints2[0];
        }
        return ints1[1] - ints2[1];
      }
    });

    for (int[] a : A) {
      priorityQueue.add(a);
    }
    for (int[] b : B) {
      priorityQueue.add(b);
    }

    //int start = priorityQueue.peek()[0];
    int end = priorityQueue.poll()[1];

    while (!priorityQueue.isEmpty()) {
      int[] next = priorityQueue.poll();
      if (next[0] <= end) {
        int[] arr = new int[2];
        arr[0] = next[0];
        arr[1] = Math.min(end, next[1]);
        list.add(arr);
      }
      end = Math.max(end, next[1]);
    }

    int[][] array = new int[list.size()][2];

    if (list.size() > 0) {
      for (int i = 0; i < list.size(); i++) {
        array[i][0] = list.get(i)[0];
        array[i][1] = list.get(i)[1];
      }
    }

    return array;


  }


  @Test
  public void test() {
    int[][] A = new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}};
    int[][] B = new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}};

    System.out.println(intervalIntersection(A, B));


  }

  @Test
  public void test1() {
    int[][] A = new int[][]{{1, 3}, {5, 9}};
    int[][] B = new int[][]{};

    System.out.println(intervalIntersection(A, B));


  }

  @Test
  public void test2() {
    int[][] A = new int[][]{{5, 10}};
    int[][] B = new int[][]{{5, 6}};

    System.out.println(intervalIntersection(A, B));


  }

  @Test
  public void test3() {
    int[][] A = new int[][]{{3, 5}, {9, 20}};
    int[][] B = new int[][]{{4, 5}, {7, 10}, {11, 12}, {14, 15}, {16, 20}};

    System.out.println(intervalIntersection(A, B));


  }

}
