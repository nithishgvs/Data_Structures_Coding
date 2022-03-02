package org.twentytwentytwo.practice;

import java.util.HashMap;
import java.util.Map;

public class FindtheTownJudge_997 {

  public int findJudge(int n, int[][] trust) {
    if (trust.length == 0 && n == 1) {
      return 1;
    }

    Map<Integer, Integer> inDegreeMap = new HashMap<>();
    Map<Integer, Integer> outDegreeMap = new HashMap<>();

    for (int[] entry : trust) {
      int src = entry[0];
      int dst = entry[1];
      int indegree = inDegreeMap.getOrDefault(dst, 0);
      int outdegree = outDegreeMap.getOrDefault(src, 0);
      inDegreeMap.put(dst, indegree + 1);
      outDegreeMap.put(src, outdegree + 1);
    }

    for (Map.Entry<Integer, Integer> entry : inDegreeMap.entrySet()) {
      if (entry.getValue() == n - 1 && !outDegreeMap.containsKey(entry.getKey())) {
        return entry.getKey();
      }
    }

    return -1;

  }

}
