package org.leetcode.Trees;

import org.junit.Test;

public class SubtreeofAnotherTree_572 {

  public boolean isSubtree(TreeNode s, TreeNode t) {

    StringBuilder sb = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();

    serializationHelper(t, sb2);
    serializationHelper(s, sb);
    //edge case
    if(s.left==null && s.right==null && t.left==null&&t.right==null){
      return s.val==t.val;
    }
    return sb.toString().indexOf(sb2.toString()) != -1;
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


  @Test
  public void test1() {
    TreeNode treeNode1 = new TreeNode(3);
    treeNode1.left = new TreeNode(4);
    treeNode1.right = new TreeNode(5);
    treeNode1.left.left = new TreeNode(1);
    treeNode1.left.right = new TreeNode(2);
    TreeNode treeNode2 = new TreeNode(4);
    treeNode2.left = new TreeNode(1);
    treeNode2.right = new TreeNode(2);
    System.out.println(isSubtree(treeNode1, treeNode2));

  }

  @Test
  public void test2() {
    TreeNode treeNode1 = new TreeNode(12);
    TreeNode treeNode2 = new TreeNode(2);
    System.out.println(isSubtree(treeNode1, treeNode2));

  }



}
