package org.leetcode.Graphs;

import java.util.List;

public interface Graph {

  enum GraphType {
    DIRECTED,
    UNDIRECTED;
  }

  public void addEdge(int v1, int v2);

  List<Integer> getAdjacentVertices(int v);

}
