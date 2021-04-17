package org.leetcode.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class FindDuplicateSubtrees_652 {

  List<TreeNode> treeNodeList = new ArrayList<>();

  Map<String, Integer> resultMap = new HashMap<>();


  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    serializationHelper(root);
    return treeNodeList;
  }


  private String serializationHelper(TreeNode root) {
    String result;
    if (root == null) {
      return "";
    } else {
      result = "l" + serializationHelper(root.left) + root.val + "r" + serializationHelper(
          root.right);
      if (!resultMap.containsKey(result)) {
        resultMap.put(result, 1);
      } else if (resultMap.get(result) == 1) {
        treeNodeList.add(root);
        resultMap.put(result, resultMap.get(result) + 1);
      }
    }
    return result;
  }


  HashMap<String, Integer> map = new HashMap<>();
  List<TreeNode> ret = new ArrayList<>();

  public List<TreeNode> findDuplicateSubtrees1(TreeNode root) {
    helper(root);
    return ret;
  }

  public String helper(TreeNode root) {
    if (root == null) {
      return "";
    }
    String str = root.val + "l" + helper(root.left) + "r" + helper(root.right);
    if (!resultMap.containsKey(str)) {
      resultMap.put(str, 1);
      return str;
    }
    int count = resultMap.get(str);
    if (count == 1) {
      ret.add(root);
      resultMap.put(str, count + 1);
    }
    return str;
  }

  @Test
  public void test1() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(4);
    root.right.left.left = new TreeNode(4);
    findDuplicateSubtrees(root);

  }//[2,2,2,3,null,3,null]


  @Test
  public void test2() {
    HelperTree tree = new HelperTree();
    TreeNode root = tree.generateBinaryTree(new Integer[]{2, 2, 2, 3, null, 3, null});
    findDuplicateSubtrees(root);
  }

  @Test
  public void test3() {
    HelperTree tree = new HelperTree();
    TreeNode root = tree.generateBinaryTree(new Integer[]{1, 2, 3, 4, null, 2, 4, null, null, 4});
    findDuplicateSubtrees1(root);
  }


  //[0,0,0,0,null,null,0,null,null,null,0]
  @Test
  public void test4() {
    HelperTree tree = new HelperTree();
    TreeNode root = tree
        .generateBinaryTree(new Integer[]{0, 0, 0, 0, null, null, 0, null, null, null, 0});
    List<TreeNode>  result=findDuplicateSubtrees(root);
    System.out.println(result);
  }

}
