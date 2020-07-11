package org.leetcode.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;

public class TwoSumBSTs_1214 {

  public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
    List<Integer> list1 = new ArrayList<>();
    inOrder(root1, list1);
    List<Integer> list2 = new ArrayList<>();
    inOrder(root2, list2);
    List<Integer> list3 = new ArrayList<>();
    list3.addAll(list1);
    list3.addAll(list2);
    return twoSum(list3, target, list1, list2);

  }

  public void inOrder(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      inOrder(root.left, list);
    }
    list.add(root.val);
    if (root.right != null) {
      inOrder(root.right, list);
    }

  }


  public boolean twoSum(List<Integer> list3, int target, List<Integer> list1, List<Integer> list2) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < list3.size(); i++) {
      map.put(list3.get(i), i);
    }
    for (int i = 0; i < list3.size(); i++) {
      int sum = target - list3.get(i);
      if (map.containsKey(sum)) {
        if ((list1.contains(list3.get(i)) && list2.contains(sum)) || (list2.contains(list3.get(i))
            && list1.contains(sum))) {
          return true;
        }
      }
    }
    return false;
  }


  @Test
  public void test1() {
    HelperTree helperTree = new HelperTree();
    TreeNode root1 = helperTree.generateBinaryTree(new Integer[]{0, -10, 10});
    TreeNode root2 = helperTree.generateBinaryTree(new Integer[]{5, 1, 7, 0, 2});
    System.out.println(twoSumBSTs(root1, root2, 18));

  }
}
