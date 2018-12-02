package org.leetcode.Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import org.junit.Test;

public class CourseScheduleII_210 {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, LinkedList<Integer>> graphMap = new HashMap<>();

    for (int i = 0; i < numCourses; i++) {
      graphMap.put(i, null);
    }

    for (int i = 0; i < prerequisites.length; i++) {
      if (graphMap.containsKey(prerequisites[i][1])) {
        LinkedList<Integer> list = null;
        if (graphMap.get(prerequisites[i][1]) == null) {
          list = new LinkedList<>();
          list.add(prerequisites[i][0]);
          graphMap.put(prerequisites[i][1], list);
        } else {
          list = graphMap.get(prerequisites[i][1]);
          list.add(prerequisites[i][0]);
          graphMap.put(prerequisites[i][1], list);
        }
      }
    }

    return topologicalSort(graphMap);
  }

  private int[] topologicalSort(Map<Integer, LinkedList<Integer>> graphMap) {

    LinkedList<Integer> queue = new LinkedList<>();

    Map<Integer, Integer> indegreeMap = new HashMap<>();

    for (Map.Entry<Integer, LinkedList<Integer>> graphVertex : graphMap.entrySet()) {
      int indegree = getIndegree(graphMap, graphVertex.getKey());
      indegreeMap.put(graphVertex.getKey(), indegree);
      if (indegree == 0) {
        queue.add(graphVertex.getKey());
      }
    }

    HashSet<Integer> vertexSet = new LinkedHashSet<>();

    while (!queue.isEmpty()) {
      int vertex = queue.pollLast();
      if (!vertexSet.add(vertex)) {
        return new int[0];
      }
      if (graphMap.get(vertex) != null) {
        for (Integer adjacentVertex : graphMap.get(vertex)) {
          int updatedIndegree = indegreeMap.get(adjacentVertex) - 1;
          indegreeMap.put(adjacentVertex, updatedIndegree);
          if (updatedIndegree == 0) {
            queue.add(adjacentVertex);
          }
        }
      }
    }
    if (vertexSet.size() != graphMap.size()) {
      return new int[0];
    }
    return vertexSet.stream().mapToInt(Number::intValue).toArray();
  }

  private int getIndegree(Map<Integer, LinkedList<Integer>> graphMap,
      Integer vertex) {
    int indegree = 0;
    for (Map.Entry<Integer, LinkedList<Integer>> graphVertex : graphMap.entrySet()) {
      if (graphVertex.getValue() != null && graphVertex.getValue().contains(vertex)) {
        indegree++;
      }
    }
    return indegree;
  }


  @Test
  public void test1() {
    int[][] prerequisites = {{1, 0}};
    findOrder(2, prerequisites);
  }

  @Test
  public void test2() {
    int[][] prereqs = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
    System.out.println(Arrays.toString(findOrder(4, prereqs)));
  }

  @Test
  public void test3() {
    int[][] prereqs = {{1, 0}, {0, 1}};
    int[] array = findOrder(2, prereqs);
    System.out.println(Arrays.toString(array));
  }

  @Test
  public void test4() {
    int[][] prereqs = {{1, 0}, {1, 2}, {0, 1}};
    int[] array = findOrder(3, prereqs);
    System.out.println(Arrays.toString(array));
  }


}
