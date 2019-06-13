package org.leetcode.Trees;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class IncreasingOrderSearchTree_897 {


  List<Integer> inorderList = new ArrayList<>();

  public TreeNode increasingBST(TreeNode root) {
    inOrder(root);
    return insertBST(inorderList);
  }

  private void inOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    inOrder(root.left);
    inorderList.add(root.val);
    inOrder(root.right);

  }

  private TreeNode insertBST(List<Integer> inorderList) {
    TreeNode root = null;
    TreeNode current = null;
    for (int i = 0; i < inorderList.size(); i++) {
      if (root == null) {
        root = new TreeNode(inorderList.get(i));
        current = root;
      } else {
        current.right = new TreeNode(inorderList.get(i));
        current = current.right;
      }

    }
    return root;
  }


  @Test
  public void test() {
    TreeNode root = new TreeNode(5);
    // Left tree in Pic
    root.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.left.left = new TreeNode(2);
    root.left.left.left = new TreeNode(1);
    // root.left.left = null;
    // Right tree in Pic
    root.right = new TreeNode(6);
    root.right.right = new TreeNode(8);
    root.right.right.left = new TreeNode(7);
    root.right.right.right = new TreeNode(9);
    increasingBST(root);
    System.out.println(Integer.MAX_VALUE);
  }


  @Test
  public void test2() {
    HelperTree helperTree = new HelperTree();
    TreeNode treeNode = helperTree.generateBinaryTree(new Integer[]{379, 826});
    increasingBST(treeNode);


  }

}
