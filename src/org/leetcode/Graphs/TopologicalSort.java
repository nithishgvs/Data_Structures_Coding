package org.leetcode.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopologicalSort {

  public List<Integer> topologicalSort(Graph graph) {
    LinkedList<Integer> queue = new LinkedList<>();
    Map<Integer, Integer> indegreeMap = new HashMap<>();

    for (int vertex = 0; vertex < graph.getNumVertices(); vertex++) {
      int indegree = graph.getIndegree(vertex);
      indegreeMap.put(vertex, indegree);
      if (indegree == 0) {
        queue.add(vertex);
      }
    }

    List<Integer> sortedList = new ArrayList<>();

    while (!queue.isEmpty()) {
      int vertex = queue.pollLast();
      sortedList.add(vertex);
      for (Integer adjacentVertex : graph.getAdjacentVertices(vertex)) {
        int updatedIndegree = indegreeMap.get(adjacentVertex) - 1;
        indegreeMap.put(adjacentVertex, updatedIndegree);
        if (updatedIndegree == 0) {
          queue.add(adjacentVertex);
        }
      }
    }

    if (sortedList.size() != graph.getNumVertices()) {
      throw new RuntimeException("Graph has a cycle");
    }

    return sortedList;

  }

}
