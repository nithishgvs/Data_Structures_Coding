package org.leetcode.Graphs;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class FindTheTownJudge_997 {

  public int findJudge(int N, int[][] trust) {
    int value = -1;

    Map<Integer, Integer> inDegreeMap = new HashMap<>();
    Map<Integer, Integer> outDegreeMap = new HashMap<>();

    for (int[] trustEdge : trust) {
      int v2 = trustEdge[1];
      int v1 = trustEdge[0];
      inDegreeMap.put(v2, inDegreeMap.getOrDefault(v2, 0) + 1);
      outDegreeMap.put(v1, outDegreeMap.getOrDefault(v1, 0) + 1);
    }

    for (Map.Entry<Integer, Integer> entry : inDegreeMap.entrySet()) {
      if (entry.getValue() == N - 1 && !outDegreeMap.containsKey(entry.getKey())) {
        return entry.getKey();
      }
    }

    return trust.length > 0 ? value : (N == 1) ? N : -1;

  }

  @Test
  public void test1() {
    int[][] trust = {{1, 2}, {2, 3}};
    System.out.println(findJudge(2, new int[][]{}));
  }

}
