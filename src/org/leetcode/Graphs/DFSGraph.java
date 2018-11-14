package org.leetcode.Graphs;

import java.util.List;
import org.junit.Test;
import org.leetcode.Graphs.Graph.GraphType;

public class DFSGraph {


  public void depthFirstSearch(Graph graph, int[] visited, int currentVertex) {
    if (visited[currentVertex] == 1) {
      return;
    }
    visited[currentVertex] = 1;
    List<Integer> adjacentVertices = graph.getAdjacentVertices(currentVertex);

    for (Integer vertex : adjacentVertices) {
      depthFirstSearch(graph, visited, vertex);
    }
    System.out.print(currentVertex + "->");
  }


  @Test
  public void testDFS() {
    int numVertices = 0;//#vertices
    Graph graph = new AdjacencySetGraph(numVertices, GraphType.DIRECTED);
    int[] visited = new int[numVertices];
    for (int i = 0; i < numVertices; i++) {
      depthFirstSearch(graph, visited, i);
    }
  }

}
