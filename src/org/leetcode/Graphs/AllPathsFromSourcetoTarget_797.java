package org.leetcode.Graphs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class AllPathsFromSourcetoTarget_797 {

  List<List<Integer>> allPaths = new ArrayList<>();

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

    Map<Integer, List<Integer>> graphMap = new LinkedHashMap<>();
    int i = 0;
    for (int[] subGraph : graph) {
      for (int val : subGraph) {
        List<Integer> adjacentVertices = graphMap.getOrDefault(i, new ArrayList<>());
        adjacentVertices.add(val);
        graphMap.put(i, adjacentVertices);
      }
      i++;
    }

    findAllPaths(graphMap, new ArrayList<>(), 0);

    return allPaths;
  }

  private void findAllPaths(Map<Integer, List<Integer>> graphMap,
      List<Integer> paths, int startIndex) {
    List<Integer> adjacentVertices = graphMap.getOrDefault(startIndex, new ArrayList<>());
    paths.add(startIndex);
    if (adjacentVertices.isEmpty()) {
      allPaths.add(paths);
      return;
    }
    adjacentVertices.forEach(adjacentVertex -> {
      findAllPaths(graphMap, new ArrayList<>(paths), adjacentVertex);
    });
  }


  @Test
  public void test1() {
    int[][] graph = {{1, 2}, {3}, {3}, {}};
    allPathsSourceTarget(graph);
  }


}
