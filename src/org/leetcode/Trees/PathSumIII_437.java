package org.leetcode.Trees;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class PathSumIII_437 {

  int count = 0;

  Set<TreeNode> set = new HashSet<>();

  public int pathSum(TreeNode root, int sum) {

    if (root == null) {
      return 0;
    }

    if (!set.contains(root)) {
      set.add(root);
      pathSumHelper(root, 0, sum);
    }

    return count;

  }


  private void pathSumHelper(TreeNode root, int currentSum, int sum) {

    if (root == null) {
      return;
    }
    if (currentSum + root.val == sum) {
      count++;
    }

    pathSumHelper(root.left, currentSum + root.val, sum);
    pathSumHelper(root.right, currentSum + root.val, sum);
    pathSum(root.right, sum);
    pathSum(root.left, sum);


  }


  @Test
  public void test() {

    HelperTree helperTree = new HelperTree();
    TreeNode node = helperTree
        .generateBinaryTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
    System.out.println(pathSum(node, 8));

  }
  //1,null,2,null,3,null,4,null,5

  @Test
  public void test1() {

    HelperTree helperTree = new HelperTree();
    TreeNode node = helperTree
        .generateBinaryTree(new Integer[]{1, null, 2, null, 3, null, 4, null, 5});
    System.out.println(pathSum(node, 3));

  }

}
