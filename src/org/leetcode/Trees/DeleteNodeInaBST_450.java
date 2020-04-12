package org.leetcode.Trees;

import org.junit.Test;

public class DeleteNodeInaBST_450 {

  public TreeNode deleteNode(TreeNode root, int key) {



    return root;
  }

  @Test
  public void treeTest1() {
    TreeNode root = new TreeNode(52);
    root.left = new TreeNode(33);
    root.left.left = new TreeNode(25);
    root.left.left.left = new TreeNode(12);
    root.left.left.right = new TreeNode(27);
    root.left.right = new TreeNode(39);
    root.left.right.left = new TreeNode(34);
    root.left.right.right = new TreeNode(48);
    root.right = new TreeNode(65);
    root.right.left = new TreeNode(60);
    root.right.right = new TreeNode(78);
    root.right.right.left = new TreeNode(72);
    root.right.right.right = new TreeNode(90);
    BinaryTreeInorderTraversal_94 binaryTreeInorderTraversal_94 = new BinaryTreeInorderTraversal_94();
    binaryTreeInorderTraversal_94.inOrderRecursive(root);
    binaryTreeInorderTraversal_94.inOrderRecursive(deleteNode(root,90));
  }

}
