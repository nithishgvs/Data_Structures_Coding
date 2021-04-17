package org.leetcode.UnionFind;

import org.junit.Test;

public class NumberofProvinces_547 {

  private int[] id;

  private int noOfComponents;


  public int findCircleNum(int[][] isConnected) {

    id = new int[isConnected.length + 1];

    for (int i = 1; i < id.length; i++) {
      id[i] = i;
    }
    noOfComponents = isConnected.length;

    for (int i = 0; i < isConnected.length; i++) {
      for (int j = 0; j < isConnected[0].length; j++) {
        if (isConnected[i][j] == 1) {
          union(i + 1, j + 1);
        }
      }
    }

    return noOfComponents;

  }


  private int find(int p) {
    int root = p;

    while (id[root] != root) {
      root = id[root];
    }
    while (p != root) {
      int next = id[p];
      id[p] = root;
      p = next;
    }
    return root;
  }

  private boolean isConnected(int p, int q) {
    return find(p) == find(q);
  }


  private void union(int p, int q) {
    if (isConnected(p, q)) {
      return;
    }

    int root1 = find(p);
    int root2 = find(q);

    id[root1] = root2;

    noOfComponents--;
  }


  @Test
  public void test1() {
    int[][] isConnected = {{1,0,0}, {0,1,0}, {0,0,1}};
    System.out.println(findCircleNum(isConnected));
    System.out.println(9/2);
  }

}
