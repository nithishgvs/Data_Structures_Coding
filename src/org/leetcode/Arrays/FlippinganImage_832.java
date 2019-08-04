package org.leetcode.Arrays;

import org.junit.Test;

public class FlippinganImage_832 {

  public int[][] flipAndInvertImage(int[][] A) {

    for (int[] a : A) {
      for (int start = 0, end = a.length - 1; start <= end; start++, end--) {
        int aux = a[start];
        a[start] = a[end];
        a[end] = aux;
      }
    }

    for (int[] a : A) {
      for (int i = 0; i < a.length; i++) {
        a[i] = (a[i] == 1) ? 0 : 1;
      }
    }

    return A;
  }


  @Test
  public void test1() {
    flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}});
  }


}
