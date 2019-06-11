package org.leetcode.Graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Dijkstra {

  public class DistanceInfo {

    private int distance;
    private int lastVertex;

    public DistanceInfo() {
      this.distance = Integer.MAX_VALUE;
      this.lastVertex = -1;
    }

    public int getDistance() {
      return distance;
    }

    public void setDistance(int distance) {
      this.distance = distance;
    }

    public int getLastVertex() {
      return lastVertex;
    }

    public void setLastVertex(int lastVertex) {
      this.lastVertex = lastVertex;
    }
  }

  public class VertexInfo {

    private int vertexId;
    private int distance;

    public VertexInfo(int vertexId, int distance) {
      this.vertexId = vertexId;
      this.distance = distance;
    }

    public int getVertexId() {
      return vertexId;
    }

    public int getDistance() {
      return distance;
    }
  }


  public Map<Integer, DistanceInfo> buildDDistanceTable(Graph graph, int sourceVetex) {
    Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
    PriorityQueue<VertexInfo> queue = new PriorityQueue<>(
        (v1, v2) -> v1.getDistance() - (v2.getDistance()));

    for (int i = 0; i < graph.getNumVertices(); i++) {
      distanceTable.put(i, new DistanceInfo());
    }

    distanceTable.get(sourceVetex).setDistance(0);
    distanceTable.get(sourceVetex).setLastVertex(sourceVetex);

    Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();

    VertexInfo sourceVertexInfo = new VertexInfo(sourceVetex, 0);
    queue.add(sourceVertexInfo);

    vertexInfoMap.put(sourceVetex, sourceVertexInfo);

    //Build the Distance Table

    while (!queue.isEmpty()) {
      VertexInfo vertexInfo = queue.poll();
      int currentVertex = vertexInfo.getVertexId();
      for (Integer neighbour : graph.getAdjacentVertices(currentVertex)) {
        int distance =
            distanceTable.get(currentVertex).getDistance() + graph
                .getWeightedEdge(currentVertex, neighbour);
        if (distanceTable.get(neighbour).getDistance() > distance) {
          distanceTable.get(neighbour).setDistance(distance);
          distanceTable.get(neighbour).setLastVertex(currentVertex);

          VertexInfo neighbourVertexInfo = vertexInfoMap.get(neighbour);

          if (neighbourVertexInfo != null) {
            queue.remove(neighbourVertexInfo);
          }

          neighbourVertexInfo = new VertexInfo(neighbour, distance);
          queue.add(neighbourVertexInfo);
          vertexInfoMap.put(neighbour, neighbourVertexInfo);
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
      System.out.println("Dijkstra is Done!");
    }
  }


}
