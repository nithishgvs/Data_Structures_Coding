package org.leetcode.Graphs;

import java.util.ArrayList;
import java.util.List;

public class AdjacencySetGraph implements Graph {

  public int numVertices = 0;
  private List<Node> verticesList = new ArrayList<>();
  private GraphType graphType = GraphType.DIRECTED;

  private AdjacencySetGraph(int numVertices, GraphType graphType) {
    this.numVertices = numVertices;
    this.graphType = graphType;
    for (int i = 0; i < numVertices; i++) {
      verticesList.add(new Node(i));
    }
  }


  @Override
  public void addEdge(int v1, int v2) {
    if (v1 < 0 || v1 >= numVertices || v2 < 0 || v2 >= numVertices) {
      throw new IllegalArgumentException("The given vertices are invalid");
    }
    verticesList.get(v1).addEdge(v2);
    if (graphType == GraphType.UNDIRECTED) {
      verticesList.get(v2).addEdge(v1);
    }
  }

  @Override
  public List<Integer> getAdjacentVertices(int v) {
    if (v < 0 || v >= numVertices) {
      throw new IllegalArgumentException("The given vertex is invalid");
    }
    return verticesList.get(v).getAdjacentVertices();
  }
}
