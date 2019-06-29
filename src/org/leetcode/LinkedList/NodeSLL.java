package org.leetcode.LinkedList;

public class NodeSLL<T> {

  public T getData() {
    return data;
  }

  public NodeSLL(T data) {
    this.data = data;
  }

  public NodeSLL<T> getNextNode() {
    return nextNode;
  }

  public void setNextNode(NodeSLL<T> nextNode) {
    this.nextNode = nextNode;
  }

  @Override
  public String toString() {
    return "Data: " + this.data;
  }

  /**
   * Display Node's data
   */
  public void displayNode() {
    System.out.print(data + " ");
  }

  private T data;
  private NodeSLL<T> nextNode;
}
