package org.nithishgvs.Practice;

public class GraphNode {

  private int vertexNumber;
  private String name;
  private int nextVertex;

  public GraphNode(int vertexNumber, String name, int nextVertex) {
    this.vertexNumber = vertexNumber;
    this.name = name;
    this.nextVertex = nextVertex;
  }
}
