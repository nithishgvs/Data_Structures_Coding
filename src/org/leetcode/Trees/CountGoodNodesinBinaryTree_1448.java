package org.leetcode.Trees;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.Test;

public class CountGoodNodesinBinaryTree_1448 {

  int count = 0;

  public int goodNodes(TreeNode root) {
    if (root == null) {
      return count;
    }
    goodNodesHelper2(root, root.val);
    return count;
  }

  private void goodNodesHelper2(TreeNode root, int val) {
    if (root == null) {
      return;
    }

    if (root.val >= val) {
      count++;
    }

    goodNodesHelper2(root.left, Math.max(val, root.val));
    goodNodesHelper2(root.right, Math.max(val, root.val));
  }

  private void goodNodesHelper(TreeNode root, ArrayList<Integer> list) {
    if (root == null) {
      return;
    }

    Collections.sort(list);

    if (list.isEmpty() || list.get(list.size() - 1) <= root.val) {
      count++;
    }
    ArrayList<Integer> newList = new ArrayList<>();
    newList.addAll(list);
    newList.add(root.val);
    goodNodesHelper(root.left, newList);
    goodNodesHelper(root.right, newList);

  }

  @Test
  public void test() {
    HelperTree helperTree = new HelperTree();
    TreeNode goodNodes = helperTree.generateBinaryTree(new Integer[]{3,1,4,3,null,1,5});
    System.out.println(goodNodes(goodNodes));
  }

}
