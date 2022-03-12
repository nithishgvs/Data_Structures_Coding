package org.twentytwentytwo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.junit.Test;

public class IsGraphBipartite_785 {


  public boolean isBipartite(int[][] graph) {

    int[] colorArray = new int[graph.length];
    Arrays.fill(colorArray, -1);

    Map<Integer, List<Integer>> graphMap = new HashMap<>();

    for (int i = 0; i < graph.length; i++) {
      List<Integer> adjacentVertices = graphMap.getOrDefault(i, new ArrayList<>());
      for (int j : graph[i]) {
        adjacentVertices.add(j);
      }
      graphMap.put(i, adjacentVertices);
    }

    for (Integer vertex : graphMap.keySet()) {
      if (colorArray[vertex] == -1) {
        colorArray[vertex] = 0;
        if (!isBipartiteHelper(colorArray, graphMap, vertex)) {
          return false;
        }
      }
    }

    return true;

  }

  private boolean isBipartiteHelper(int[] colorArray, Map<Integer, List<Integer>> graphMap,
      int vertex) {

    Queue<Integer> queue = new LinkedList<>();

    queue.add(vertex);

    while (!queue.isEmpty()) {

      int sourceVertex = queue.poll();

      for (Integer adjacent : graphMap.get(sourceVertex)) {
        if (colorArray[adjacent] == colorArray[sourceVertex]) {
          return false;
        }
        if (colorArray[adjacent] == -1 && colorArray[adjacent] != colorArray[sourceVertex]) {
          colorArray[adjacent] = 1 - colorArray[sourceVertex];
          queue.add(adjacent);
        }
      }


    }

    return true;
  }

  @Test
  public void test() {
    int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
    System.out.println(isBipartite(graph));
  }

}
