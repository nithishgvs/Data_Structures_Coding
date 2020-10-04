package org.leetcode.Trees;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class ClosestLeafBinaryTree_742 {


  Map<Integer, Integer> parentChildMap = new HashMap<>();

  Map<Integer, TreeCustomNode> nodeClosest = new HashMap<>();


  public class TreeCustomNode {

    private TreeNode treeNode;
    private int distance;

    public TreeCustomNode(TreeNode treeNode, int distance) {
      this.treeNode = treeNode;
      this.distance = distance;
    }
  }

  public int findClosestLeaf(TreeNode root, int k) {

    helper(root);
    if (parentChildMap.containsKey(k)) {
      if (nodeClosest.get(k).distance < nodeClosest.get(parentChildMap.get(k)).distance + 1) {
        return nodeClosest.get(k).treeNode.val;
      } else {
        return nodeClosest.get(parentChildMap.get(k)).treeNode.val;
      }
    } else {
      return nodeClosest.get(k).treeNode.val;
    }
  }

  private TreeCustomNode helper(TreeNode root) {
    if (root == null) {
      return new TreeCustomNode(null, Integer.MAX_VALUE);
    }
    if (root.left == null && root.right == null) {
      TreeCustomNode treeCustomNode = new TreeCustomNode(root, 1);
      nodeClosest.put(root.val, treeCustomNode);
      return treeCustomNode;
    }
    if (root.left != null) {
      parentChildMap.put(root.left.val, root.val);
    }
    if (root.right != null) {
      parentChildMap.put(root.right.val, root.val);
    }

    TreeCustomNode left = helper(root.left);

    TreeCustomNode right = helper(root.right);

    int lowest = 1 + Math.min(left.distance, right.distance);
    TreeCustomNode treeCustomNode;
    if (left.distance < right.distance) {
      treeCustomNode = new TreeCustomNode(left.treeNode, lowest);
      nodeClosest.put(root.val, treeCustomNode);
    } else {
      treeCustomNode = new TreeCustomNode(right.treeNode, lowest);
      nodeClosest.put(root.val, treeCustomNode);
    }

    return treeCustomNode;
  }


  @Test
  public void test1() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree
        .generateBinaryTree(new Integer[]{1, 2, 3, 4, null, null, null, 5, null, 6});
    System.out.println(findClosestLeaf(root, 4));
  }

  @Test
  public void test2() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree
        .generateBinaryTree(new Integer[]{1, 3, 2});
    System.out.println(findClosestLeaf(root, 1));
  }

  @Test
  public void test3() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree
        .generateBinaryTree(new Integer[]{1, 2, 3, null, null, 4, 5, 6, null, null, 7, 8, 9, 10});
    System.out.println(findClosestLeaf(root, 3));
  }
}
