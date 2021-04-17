package org.leetcode.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.junit.Test;

public class IsGraphBipartite_785 {

  Map<Integer, List<Integer>> graphMap = new HashMap<>();

  public boolean isBipartite(int[][] graph) {
    int[] color = new int[graph.length];
    Arrays.fill(color, -1);

    for (int i = 0; i < graph.length; i++) {
      int[] edges = graph[i];
      List<Integer> edgeList = graphMap.getOrDefault(i, new ArrayList<>());
      for (int edge : edges) {
        edgeList.add(edge);
      }
      graphMap.put(i, edgeList);
    }

    for (int key : graphMap.keySet()) {
      if (color[key] == -1) {
        color[key] = 0;
        if (!bipartiteHelper(key, color)) {
          return false;
        }
      }
    }

    return true;
  }

  private boolean bipartiteHelper(int key, int[] color) {
    color[key] = 1;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(key);
    while (!queue.isEmpty()) {
      int vertex = queue.poll();
      int sourceColor = color[vertex];
      List<Integer> edgeList = graphMap.get(vertex);

      for (int edge : edgeList) {
        if (color[edge] == sourceColor) {
          return false;
        }
        if (color[edge] == -1 && color[edge] != sourceColor) {
          color[edge] = 1 - sourceColor;
          queue.add(edge);
        }
      }

    }

    return true;
  }


  @Test
  public void test1() {
    int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
    System.out.println(isBipartite(graph));
  }

  @Test
  public void test2() {
    int[][] graph = {{1, 3}, {0, 2}, { 1, 3}, {0, 2}};
    System.out.println(isBipartite(graph));
  }
}
