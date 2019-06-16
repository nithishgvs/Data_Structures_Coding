package org.leetcode.Trees;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class BinarySearchTreetoGreaterSumTree_1038 {


  List<Integer> list = new ArrayList<>();

  public TreeNode bstToGst(TreeNode root) {
    if(root==null){
      return root;
    }
    inOrderRecursive(root, false);
    inOrderRecursive(root, true);
    return root;
  }


  public void inOrderRecursive(TreeNode root, boolean flag) {
    if (root == null) {
      return;
    }

    inOrderRecursive(root.left, flag);
    if (!flag) {
      list.add(root.val);
    } else {
      root.val = replaceValue(list, root.val);
    }
    inOrderRecursive(root.right, flag);
  }

  private int replaceValue(List<Integer> list, int val) {

    int newVal = 0;

    for (Integer elem : list) {
      if (elem >= val) {
        newVal += elem;
      }
    }

    return newVal;

  }


  @Test
  public void testGreaterTree() {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(2);
    root.left.right.right = new TreeNode(3);
    root.right = new TreeNode(6);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(7);
    root.right.right.right = new TreeNode(8);
    list = new ArrayList<>();
    inOrderRecursive(bstToGst(root), false);
    list.stream().forEach(v -> System.out.println(v));
  }
}
