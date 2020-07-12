package org.leetcode.BinarySearch;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;
//ones (representing soldiers) and zeros (representing civilians)

public class TheKWeakestRowsinaMatrix_1337 {

  public int[] kWeakestRows(int[][] mat, int k) {

    int[] weakRows = new int[k];

    Map<Integer, Integer> unSortedMap = new LinkedHashMap<>();

    int j = 0;

    for (int[] subMat : mat) {
      int index = firstOccurenceOfSoldier(subMat);
      if (index == -1) {
        unSortedMap.put(j, 0);
      } else {
        unSortedMap.put(j, subMat.length - index);
      }
      j++;
    }

    LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();

    unSortedMap.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue())
        .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

    int i = 0;

    for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
      if (i == k) {
        break;
      }
      weakRows[i++] = entry.getKey();
    }

    return weakRows;

  }

  public int firstOccurenceOfSoldier(int[] subMat) {
    int index = -1;

    int low = 0, high = subMat.length - 1;
    Arrays.sort(subMat);

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (subMat[mid] == 1) {
        index = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }

    }

    return index;

  }


  @Test
  public void test() {

    int[][] mat = {{1, 1, 0, 0, 0},
        {1, 1, 1, 1, 0},
        {1, 0, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {1, 1, 1, 1, 1}};

    System.out.println(kWeakestRows(mat, 3));

  }

  @Test
  public void test1() {

    int[][] mat = {{1, 0}, {0, 0}, {1, 0}};

    System.out.println(kWeakestRows(mat, 2));

  }


}
