package org.leetcode.Graphs;

import java.util.LinkedList;
import org.junit.Test;
import org.leetcode.Graphs.Graph.GraphType;

public class BFSGraph {

  public void breadthFirstSearch(Graph graph, int[] visited, int currentVertex) {
    LinkedList<Integer> queue = new LinkedList<>();
    queue.add(currentVertex);

    while (!queue.isEmpty()) {
      int vertex = queue.pollLast();
      if (visited[vertex] == 1) {
        continue;
      }
      visited[currentVertex] = 1;

      for (Integer v : graph.getAdjacentVertices(vertex)) {
        if (visited[v] != 1) {
          queue.add(v);
        }
      }
    }
  }

  @Test
  public void testDFS() {
    int numVertices = 0;//#vertices
    Graph graph = new AdjacencySetGraph(numVertices, GraphType.DIRECTED);
    int[] visited = new int[numVertices];
    for (int i = 0; i < numVertices; i++) {
      breadthFirstSearch(graph, visited, i);
    }
  }

}
