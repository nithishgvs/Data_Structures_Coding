package org.leetcode.Trees;

import org.junit.Test;

public class MergeTwoBinaryTrees_617 {

  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

    if (t1 == null && t2 == null) {
      return null;
    }

    TreeNode newNode = new TreeNode(0);

    if (t1 != null) {
      newNode.val += t1.val;
    }
    if (t2 != null) {
      newNode.val += t2.val;
    }

    newNode.left = mergeTrees(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
    newNode.right = mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right : null);

    return newNode;

  }


  @Test
  public void test(){
    TreeNode node1=new TreeNode(1);
    node1.left=new TreeNode(3);
    node1.right=new TreeNode(2);
    node1.left.left=new TreeNode(5);
    TreeNode node2=new TreeNode(2);
    node2.left=new TreeNode(1);
    node2.right=new TreeNode(3);
    node2.left.right=new TreeNode(4);
    node2.right.right=new TreeNode(7);
    BinaryTreeInorderTraversal_94 binaryTreeInorderTraversal_94=new BinaryTreeInorderTraversal_94();
    TreeNode node3=mergeTrees(node1,node2);
    //binaryTreeInorderTraversal_94.inOrderRecursive(node3);
  }

}
