package org.leetcode.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class MinimumNumberofVerticestoReachAllNodes_1557 {

  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    List<Integer> result = new ArrayList<>();

    Map<Integer, Integer> inDegreeMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      inDegreeMap.put(i, 0);
    }

    for (int i = 0; i < edges.size(); i++) {
      List<Integer> edge = edges.get(i);
      Integer to = edge.get(1);
      inDegreeMap.put(to, inDegreeMap.get(to) + 1);
    }

    for (Map.Entry<Integer, Integer> entry : inDegreeMap.entrySet()) {
      if (entry.getValue() == 0) {
        result.add(entry.getKey());
      }
    }

    return result;
  }

  @Test
  public void test1() {
    //{{0,1},{0,2},{2,5},{3,4},{4,2}}

    List<List<Integer>> edges = new ArrayList<>();
    edges.add(Arrays.asList(0, 1));
    edges.add(Arrays.asList(2, 1));
    edges.add(Arrays.asList(3, 1));
    edges.add(Arrays.asList(1, 4));
    edges.add(Arrays.asList(2, 4));
    findSmallestSetOfVertices(5, edges);
  }

}
