package org.leetcode.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class FindCenterofStarGraph_1791 {


  public int findCenter(int[][] edges) {

    Map<Integer, List<Integer>> map = new HashMap<>();

    for (int[] edge : edges) {
      int v1 = edge[0];
      int v2 = edge[1];
      //undirected
      List<Integer> v1MapList = map.getOrDefault(v1, new ArrayList<>());
      v1MapList.add(v2);
      map.put(v1, v1MapList);
      List<Integer> v2MapList = map.getOrDefault(v2, new ArrayList<>());
      v2MapList.add(v1);
      map.put(v2, v2MapList);

    }

    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      if (map.size() - 1 == entry.getValue().size()) {
        return entry.getKey();
      }
    }

    return -1;

  }


  @Test
  public void tes1(){
    int[][] edges=new int[][]{{1,2},{5,1},{1,3},{1,4}};
    System.out.println(findCenter(edges));
  }


}
