package org.leetcode.Trees;

import java.util.List;
import org.junit.Test;

/**
 * https://www.youtube.com/watch?v=nPtARJ2cYrg Tree ->acyclic graph is the suggestion
 */
public class AllNodesDistanceKinBinaryTree_863 {


  public class NodeHelper {

    TreeNode root;
    int level;


    public NodeHelper(TreeNode root, int level) {
      this.root = root;
      this.level = level;
    }
  }

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    if (root == null || target == null) {
      return null;
    }

    return null;
  }

  @Test
  public void test1() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree
        .generateBinaryTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
    distanceK(root, new TreeNode(5), 2).forEach(v -> System.out.println(v));
  }

  @Test
  public void test2() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree
        .generateBinaryTree(new Integer[]{0, null, 1, null, 2, null, 3});
    distanceK(root, new TreeNode(1), 2).forEach(v -> System.out.println(v));
  }

  @Test
  public void test3() {
    HelperTree helperTree = new HelperTree();
    TreeNode root = helperTree
        .generateBinaryTree(new Integer[]{0, 1, null, 3, 2});
    distanceK(root, new TreeNode(2), 1).forEach(v -> System.out.println(v));
  }
}
