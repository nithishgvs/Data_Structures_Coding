package org.leetcode.Trees;


import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

public class Codec {

  // Encodes a tree to a single string.

  public String serialize(TreeNode root) {

    StringBuilder stringBuilder = new StringBuilder();

    serializationHelper(root, stringBuilder);

    return stringBuilder.toString();

  }

  private void serializationHelper(TreeNode root, StringBuilder stringBuilder) {
    if (root == null) {
      stringBuilder.append("#").append(",");
    } else {
      stringBuilder.append(root.val).append(",");
      serializationHelper(root.left, stringBuilder);
      serializationHelper(root.right, stringBuilder);
    }
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {

    String[] arr = data.split(",");
    Queue<String> queue = new LinkedList<>();

    for (String a : arr) {
      queue.add(a);
    }
    return deserializeHelper(queue);


  }

  private TreeNode deserializeHelper(Queue<String> queue) {
    String polled = queue.poll();
    if (polled.equals("#")) {
      return null;
    }

    TreeNode treeNode = new TreeNode(Integer.valueOf(polled));
    treeNode.left = deserializeHelper(queue);
    treeNode.right = deserializeHelper(queue);
    return treeNode;
  }


  @Test
  public void test1() {
    Integer[] array = new Integer[]{1, 2, 3, null, null, 4, 5};
    HelperTree helperTree = new HelperTree();
    TreeNode treeNode = helperTree.generateBinaryTree(array);
    System.out.println(deserialize(serialize(treeNode)));

  }
}


