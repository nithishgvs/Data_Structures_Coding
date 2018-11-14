package org.leetcode.Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class ShortestPathUnweightedGraph {

  public Map<Integer, DistanceInfo> buildDDistanceTable(Graph graph, int sourceVetex) {
    Map<Integer, DistanceInfo> distanceTable = new HashMap<>();

    for (int i = 0; i < graph.getNumVertices(); i++) {
      distanceTable.put(i, new DistanceInfo());
    }

    LinkedList<Integer> queue = new LinkedList<>();

    distanceTable.get(sourceVetex).setDistance(0);
    distanceTable.get(sourceVetex).setLastVertex(sourceVetex);

    queue.add(sourceVetex);

    while (!queue.isEmpty()) {
      int currentVertex = queue.pollFirst();
      for (int i : graph.getAdjacentVertices(currentVertex)) {
        int currentDistance = distanceTable.get(i).getDistance();
        if (currentDistance == -1) {
          currentDistance = distanceTable.get(currentVertex).getDistance() + 1;
          distanceTable.get(i).setLastVertex(currentVertex);
          distanceTable.get(i).setDistance(currentDistance);
        }
        //Enqueue only if the neighbour has adjacent veritices
        if (!graph.getAdjacentVertices(i).isEmpty()) {
          queue.add(i);
        }
      }

    }

    return distanceTable;
  }

  public void shortestPath(Graph graph, int source, int destination) {
    Map<Integer, DistanceInfo> distanceTable = buildDDistanceTable(graph, source);
    Stack<Integer> stack = new Stack<>();
    stack.add(destination);

    int previousVertex = distanceTable.get(destination).getLastVertex();

    while (previousVertex != -1 && previousVertex != source) {
      stack.add(previousVertex);
      previousVertex = distanceTable.get(previousVertex).getLastVertex();
    }

    if (previousVertex == -1) {
      throw new RuntimeException("Shortest Path can't be found");
    } else {
      System.out.print("Shortest path is:" + previousVertex);
      while (!stack.isEmpty()) {
        System.out.print("->" + stack.pop());
      }
      System.out.println("Shortest Path Unweighted Graph is Done!");
    }
  }


}
