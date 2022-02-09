package org.seanparshad.practice;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class ConstructBinaryTreefromInorderandPostorderTraversal_106 {


  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  int n = 0;

  public TreeNode buildTree(int[] inorder, int[] postorder) {

    Map<Integer, Integer> inorderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderMap.put(inorder[i], i);
    }
    n = postorder.length - 1;
    return treeHelper(postorder, inorderMap, 0, inorder.length - 1);
  }

  private TreeNode treeHelper(int[] postorder, Map<Integer, Integer> inorderMap, int start,
      int end) {
    if (start > end) {
      return null;
    }
    int rootValue = postorder[n];
    n--;
    int rootIndex = inorderMap.get(rootValue);
    TreeNode root = new TreeNode(rootValue);
    root.right = treeHelper(postorder, inorderMap, rootIndex + 1, end);
    root.left = treeHelper(postorder, inorderMap, start, rootIndex - 1);

    return root;
  }


  public void inorderTraversal(TreeNode root) {
    if (root == null) {
      return;
    }
    inorderTraversal(root.left);
    System.out.print(root.val + "->");
    inorderTraversal(root.right);
  }


  @Test
  public void test1() {
    int[] inorder = {9, 3, 15, 20, 7};
    int[] postorder = {9, 15, 7, 20, 3};
    TreeNode root = buildTree(inorder, postorder);
    inorderTraversal(root);
  }


  @Test
  public void testConstructTree2() {

    int[] inorder = {12, 25, 27, 33, 34, 39, 48, 52, 60, 65, 72, 78, 90};
    int[] postOrder = {12, 27, 25, 34, 48, 39, 33, 60, 72, 90, 78, 65, 52};
    TreeNode root = buildTree(inorder, postOrder);
    inorderTraversal(root);

  }

  @Test
  public void testConstructTree3() {

    int[] inorder = {1, 2, 3, 4};
    int[] postOrder = {3, 2, 4, 1};

    TreeNode root = buildTree(inorder, postOrder);
    inorderTraversal(root);

  }
}

