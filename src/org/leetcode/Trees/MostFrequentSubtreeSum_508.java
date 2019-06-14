package org.leetcode.Trees;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class MostFrequentSubtreeSum_508 {


  Map<Integer, Integer> map = new LinkedHashMap<>();

  int maxValue = Integer.MIN_VALUE;

  public int[] findFrequentTreeSum(TreeNode root) {
    if (root == null) {
      return new int[]{};
    }
    findFrequentTreeSumHelper(root);
    List<Integer> list = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == maxValue) {
        list.add(entry.getKey());
      }
    }
    return list.stream().mapToInt(i -> i).toArray();
  }

  private int findFrequentTreeSumHelper(TreeNode root) {

    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      updateMap(root.val);
      maxValue = Math.max(maxValue, map.get(root.val));
      return root.val;
    } else {
      int sum =
          root.val + findFrequentTreeSumHelper(root.left) + findFrequentTreeSumHelper(root.right);
      updateMap(sum);
      maxValue = Math.max(maxValue, map.get(sum));
      return sum;
    }

  }

  private void updateMap(Integer value) {
    if (!map.containsKey(value)) {
      map.put(value, 1);
    } else {
      map.put(value, 1 + map.get(value));
    }
  }


  @Test
  public void findFrequentTreeSumHelperTest1() {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(-3);
    int[] arr = findFrequentTreeSum(root);
  }

  @Test
  public void findFrequentTreeSumHelperTest2() {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(-5);
    int[] arr = findFrequentTreeSum(root);
  }

  @Test
  public void findFrequentTreeSumHelperTest3() {
    TreeNode root = new TreeNode(1);
    HelperTree helperTree = new HelperTree();
    TreeNode treeNode = helperTree.generateBinaryTree(new Integer[]{5, 14, null, 1});
    int[] arr = findFrequentTreeSum(treeNode);
  }

}
