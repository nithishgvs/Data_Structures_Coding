package org.leetcode.Trees;

import org.junit.Test;

public class SmallestStringStartingFromLeaf_988 {

  String output = "";


  public String smallestFromLeaf(TreeNode root) {
    return output(root);
  }

  public String output(TreeNode node) {
    if (node == null) {
      return null;
    } else {
      char ch = (char) ('a' + node.val);
      String left = output(node.left);
      String right = output(node.right);
      if (left == null && right == null) {
        return "" + ch;
      }
      if (left == null || right == null) {
        return left != null ? left + ch : right + ch;
      } else {
        if (left.compareTo(right) <= 0) {
          return left + ch;
        } else {
          return right + ch;
        }
      }
    }
  }


  public String smallestFromLeaf1(TreeNode root) {

    if (root == null) {
      return null;
    }

    treeHelper(root, new StringBuilder());
    return output;

  }

  private void treeHelper(TreeNode root, StringBuilder stringBuilder) {

    stringBuilder.append((char) (97 + root.val));

    if (root.left == null && root.right == null) {
      String interestedString = stringBuilder.reverse().toString();
      if (output.length() > 0) {
        output = output.compareTo(interestedString) < 0 ? output
            : interestedString;
      } else {
        output = interestedString;
      }
      return;
    }

    if (root.left != null) {
      treeHelper(root.left, new StringBuilder(stringBuilder));
    }

    if (root.right != null) {
      treeHelper(root.right, new StringBuilder(stringBuilder));
    }

  }


  @Test
  public void test() {
    HelperTree helperTree = new HelperTree();
    TreeNode treeNode = helperTree.generateBinaryTree(new Integer[]{25, 1, 3, 1, 3, 0, 2});
    System.out.println(smallestFromLeaf(treeNode));
  }
}
