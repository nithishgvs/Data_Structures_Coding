package org.epi.Queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import org.junit.Test;

//Level order traversal
public class BinaryTreeDepthOrder {

  public List<List<Integer>> binaryTreeDepthOrder(BinaryTreeNode<Integer> root) {
    if (root == null) {
      return null;
    }
    List<List<Integer>> outputList = new ArrayList<>();
    Deque<BinaryTreeNode> currentNodes = new ArrayDeque<>();
    currentNodes.add(root);

    while (!currentNodes.isEmpty()) {
      Deque<BinaryTreeNode> nextNodes = new ArrayDeque<>();
      List<Integer> currentDepthValues = new ArrayList<>();
      while (!currentNodes.isEmpty()) {
        BinaryTreeNode<Integer> currentNode = currentNodes.poll();
        currentDepthValues.add(currentNode.data);
        if (currentNode.left != null) {
          nextNodes.add(currentNode.left);
        }

        if (currentNode.right != null) {
          nextNodes.add(currentNode.right);
        }
      }
      currentNodes = nextNodes;
      outputList.add(currentDepthValues);
    }
    return outputList;
  }


  @Test
  public void testDepthOrder() {
    BinaryTreeNode<Integer> root = new BinaryTreeNode<>(314);
    root.left = new BinaryTreeNode<>(6);
    root.left.left = new BinaryTreeNode<>(271);
    root.left.left.left = new BinaryTreeNode<>(28);
    root.left.left.right = new BinaryTreeNode<>(0);
    root.left.right = new BinaryTreeNode<>(561);
    root.left.right.right = new BinaryTreeNode<>(3);
    root.left.right.right.left = new BinaryTreeNode<>(17);
    root.right = new BinaryTreeNode<>(6);
    root.right.left = new BinaryTreeNode<>(2);
    root.right.left.right = new BinaryTreeNode<>(1);
    root.right.left.right.left = new BinaryTreeNode<>(401);
    root.right.left.right.left.right = new BinaryTreeNode<>(641);
    root.right.left.right.right = new BinaryTreeNode<>(257);
    root.right.right = new BinaryTreeNode<>(271);
    root.right.right.right = new BinaryTreeNode<>(28);
    binaryTreeDepthOrder(root);

  }

}
