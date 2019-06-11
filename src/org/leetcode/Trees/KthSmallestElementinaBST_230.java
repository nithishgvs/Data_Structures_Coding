package org.leetcode.Trees;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class KthSmallestElementinaBST_230 {


  List<Integer> list = new ArrayList<>();

  public int kthSmallest(TreeNode root, int k) {
    inOrderTraversal(root);
    return list.get(k-1);
  }


  public void inOrderTraversal(TreeNode root) {
    if (root == null) {
      return;
    }
    inOrderTraversal(root.left);
    list.add(root.val);
    inOrderTraversal(root.right);
  }


  private TreeNode prepareTreeNode() {
    TreeNode root = new TreeNode(52);
    // Left tree in Pic
    root.left = new TreeNode(33);
    root.left.left = new TreeNode(25);
    root.left.right = new TreeNode(39);
    root.left.left.left = new TreeNode(12);
    root.left.left.right = new TreeNode(27);
    root.left.right.left = new TreeNode(34);
    root.left.right.right = new TreeNode(48);
    // Right tree in Pic
    root.right = new TreeNode(65);
    root.right.left = new TreeNode(60);
    root.right.right = new TreeNode(78);
    root.right.right.left = new TreeNode(72);
    root.right.right.right = new TreeNode(90);
    return root;
  }


  @Test
  public void testKthSmallest() {
    System.out.println(kthSmallest(prepareTreeNode(), 2));
  }

}
