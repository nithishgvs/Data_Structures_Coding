package org.leetcode.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class HelperTree {

  public TreeNode generateBinaryTree(Integer[] arr) {
    if (arr.length == 0 && arr[0] != null) {
      return null;
    }

    TreeNode node = new TreeNode(arr[0].intValue());
    int currentIndex = 0;

    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(node);
    currentIndex++;

    while (currentIndex < arr.length) {
      TreeNode current = ((LinkedList<TreeNode>) queue).pop();
      if (arr[currentIndex] != null) {
        current.left = new TreeNode(arr[currentIndex].intValue());
        queue.add(current.left);
      }
      currentIndex++;

      if (currentIndex < arr.length) {
        if (arr[currentIndex] != null) {
          current.right = new TreeNode(arr[currentIndex].intValue());
          queue.add(current.right);
        }
        currentIndex++;
      }
    }

    return node;
  }

}
