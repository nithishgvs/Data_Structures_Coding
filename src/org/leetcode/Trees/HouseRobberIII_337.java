package org.leetcode.Trees;

import org.junit.Test;

//Tried and screwed

public class HouseRobberIII_337 {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  public int rob(TreeNode root) {
    return -1;
  }



  @Test
  public void testRobber1() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right = new TreeNode(5);
    root.right.right = new TreeNode(1);
    System.out.println(rob(root));
  }

  @Test
  public void testRobber2(){
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(2);
    root.right=new TreeNode(3);
    root.left.right = new TreeNode(3);
    root.right.right=new TreeNode(1);
    System.out.println(rob(root));
  }


}
