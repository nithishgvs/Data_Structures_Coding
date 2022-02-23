package org.twentytwentytwo.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.junit.Test;

public class CourseScheduleII_210 {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, Integer> inDegreeMap = new HashMap<>();

    Set<Integer> graphVertices = new HashSet<>();
    Map<Integer, Set<Integer>> adjacentVertices = new HashMap<>();

    for (int i = 0; i < numCourses; i++) {
      graphVertices.add(i);
      adjacentVertices.put(i, new HashSet<>());
    }

    for (int i = 0; i < prerequisites.length; i++) {
      int to = prerequisites[i][0];
      int from = prerequisites[i][1];
      graphVertices.remove(to);
      int inDegree = inDegreeMap.getOrDefault(to, 0);
      Set<Integer> adjacent = adjacentVertices.get(from);
      adjacent.add(to);
      adjacentVertices.put(from, adjacent);
      inDegreeMap.put(to, inDegree + 1);
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.addAll(graphVertices);

    List<Integer> topologicalSort = new ArrayList<>();

    while (!queue.isEmpty()) {
      Integer vertex = queue.poll();
      topologicalSort.add(vertex);
      for (Integer adjacent : adjacentVertices.get(vertex)) {
        Integer value = inDegreeMap.getOrDefault(adjacent, 0);
        if (value > 0) {
          value = value - 1;
        }
        if (value == 0) {
          queue.add(adjacent);
        } else {
          inDegreeMap.put(adjacent, value);
        }
      }
    }

    return topologicalSort.size() == numCourses ? topologicalSort.stream().mapToInt(i -> i)
        .toArray() : new int[0];

  }

  @Test
  public void test1() {
    int[][] pre = {{1, 0}, {1, 2}, {0, 1}};
    findOrder(3, pre);
  }

}
