package org.leetcode.Trees;

import org.junit.Test;

public class ValidateBinarySearchTree_98 {

//  List<Integer> inOrderList = new ArrayList<>();
//
//  public boolean isValidBST2(TreeNode root) {
//    inOrderRecursive(root);
//    List<Integer> sortedList = inOrderList.stream().distinct()
//        .collect(Collectors.toCollection(ArrayList::new));
//    Collections.sort(sortedList);
//    return sortedList.equals(inOrderList);
//  }


  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    return helperTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean helperTree(TreeNode root, long minValue, long maxValue) {

    if (root == null) {
      return true;
    }
    if (root.val <= minValue || root.val >= maxValue) {
      return false;
    }

    return helperTree(root.left, minValue, root.val) && helperTree(root.right, root.val, maxValue);

  }


  @Test
  public void treeTest() {
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
    System.out.println(isValidBST(root));
  }

  @Test
  public void treeTest1() {
    TreeNode root = new TreeNode(33);
    root.left = new TreeNode(33);
    System.out.println(isValidBST(root));
  }

  @Test
  public void test1() {
    HelperTree helperTree = new HelperTree();
    TreeNode treeNode = helperTree.generateBinaryTree(new Integer[]{2, 1, 3});
    treeNode = helperTree.generateBinaryTree(new Integer[]{10, 5, 15, null, null, 6, 20});
    //treeNode = helperTree.generateBinaryTree(new Integer[]{3, 1, 5, 0, 2, 4, 6});
    //treeNode = helperTree.generateBinaryTree(new Integer[]{Integer.MAX_VALUE});
      //treeNode = helperTree.generateBinaryTree(new Integer[]{0});
    System.out.println(isValidBST(treeNode));
  }
}


