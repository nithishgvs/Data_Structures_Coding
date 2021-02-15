package org.leetcode.UnionFind;

import org.junit.Test;

public class RedundantConnection_684 {


  public int[] findRedundantConnection(int[][] edges) {
    //0th index is useless;
    int[] id = new int[edges.length + 1];
    for (int i = 0; i < id.length; i++) {
      id[i] = i;
    }

    for (int i = 0; i < edges.length; i++) {
      if (!union(edges[i][0], edges[i][1], id)) {
        return edges[i];
      }
    }
    return null;
  }


  public boolean connected(int p, int q, int[] id) {
    return find(p, id) == find(q, id);
  }


  public int find(int p, int[] id) {

    int root = p;

    while (root != id[root]) {
      root = id[root];
    }

    while (p != root) {
      int next = id[p];
      id[p] = root;
      p = next;
    }

    return root;
  }

  public boolean union(int p, int q, int[] id) {

    if (connected(p, q, id)) {
      return false;
    }
    int root1 = find(p, id);
    int root2 = find(q, id);
    id[root1] = root2;
    return true;
  }

  @Test
  public void test1() {
    //{{1, 2}, {1, 3}, {2, 3}}
    int[][] edges =
        {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
    System.out.println(findRedundantConnection(edges));
  }

}
