package org.nithishgvs.Practice;

public class HamiltonianCycle {


  private int numOfVertexes;
  private int hamiltonianPath[];
  private int[][] adjacencyMatrix;

  public void hamiltonianCycle(int adjacencyMatrix[][]) {

    this.numOfVertexes = adjacencyMatrix[0].length;
    this.hamiltonianPath = new int[this.numOfVertexes];
    this.adjacencyMatrix = adjacencyMatrix;

    this.hamiltonianPath[0] = 0;

    if (!findFeasibleSolution(1)) {
      System.out.println("No feasible solution found...");
      return;
    }else{
      showHamiltonianPath();
    }
  }

  boolean findFeasibleSolution(int position) {

    if (position == this.numOfVertexes) {
      if (this.adjacencyMatrix[this.hamiltonianPath[position - 1]][this.hamiltonianPath[0]] == 1) {
        return true;
      } else {
        return false;
      }
    }

    for (int vertexIndex = 1; vertexIndex < this.numOfVertexes; ++vertexIndex) {
      if (isFeasible(vertexIndex, position)) {

        this.hamiltonianPath[position] = vertexIndex;

        if (findFeasibleSolution(position + 1)) {
          return true;
        }
      }
    }

    return false;
  }

  boolean isFeasible(int vertex, int actualPosition) {

    // first criteria: whether the two nodes are connected?
    if (this.adjacencyMatrix[this.hamiltonianPath[actualPosition - 1]][vertex] == 0){
      return false;
    }

    //second criteria: whether we have already added this given node?
    for (int i = 0; i < actualPosition; ++i){
      if (hamiltonianPath[i] == vertex){
        return false;
      }
    }

    return true;
  }

  public void showHamiltonianPath() {

    System.out.println("Hamiltonian cycle exists: ");

    for (int i = 0; i < numOfVertexes; ++i) {
      System.out.print(this.hamiltonianPath[i] + " ");
    }

    System.out.println(this.hamiltonianPath[0]);
  }
}
