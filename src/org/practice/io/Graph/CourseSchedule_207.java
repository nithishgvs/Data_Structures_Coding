package org.practice.io.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.junit.Test;

public class CourseSchedule_207 {


  public boolean canFinish(int numCourses, int[][] prerequisites) {

    List<Integer> topologicalSort = new ArrayList<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();

    int[] inDegree = new int[numCourses];

    for (int[] preReqs : prerequisites) {
      List<Integer> adjacencyList = graph.getOrDefault(preReqs[1], new ArrayList<>());
      adjacencyList.add(preReqs[0]);
      graph.put(preReqs[1], adjacencyList);
      inDegree[preReqs[0]]++;
    }

    Queue<Integer> queue = new LinkedList<>();

    //prepare inDegree
    for (int i = 0; i < inDegree.length; i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      Integer vertex = queue.poll();
      topologicalSort.add(vertex);
      for (Integer adjVertex : graph.getOrDefault(vertex, new ArrayList<>())) {
        int updatedIndegree = inDegree[adjVertex] - 1;
        inDegree[adjVertex] = updatedIndegree;
        if (updatedIndegree == 0) {
          queue.add(adjVertex);
        }
      }

    }

    return topologicalSort.size() == numCourses;

  }


  @Test
  public void test() {
    //System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    System.out.println(canFinish(2, new int[][]{{1, 0}}));
  }


}
