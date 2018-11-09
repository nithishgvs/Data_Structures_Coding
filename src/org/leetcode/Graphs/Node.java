package org.leetcode.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Node {


  private int vertexNumber;
  private Set<Integer> adjacencySet = new HashSet<>();

  public Node(int vertexNumber) {
    this.vertexNumber = vertexNumber;
  }

  public int getVertexNumber() {
    return vertexNumber;
  }

  public void addEdge(int vertexNumber) {
    adjacencySet.add(vertexNumber);
  }


  public List<Integer> getAdjacentVertices() {
    List<Integer> adjacentVerticesList = new ArrayList<>(adjacencySet);
    Collections.sort(adjacentVerticesList);
    return adjacentVerticesList;

  }


}
