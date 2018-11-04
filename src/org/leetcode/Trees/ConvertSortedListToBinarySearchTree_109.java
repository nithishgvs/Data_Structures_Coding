package org.leetcode.Trees;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ConvertSortedListToBinarySearchTree_109 {

  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }
    List<Integer> list = returnList(head);
    return sortedListHelper(list, 0, list.size() - 1);

  }

  private TreeNode sortedListHelper(List<Integer> list, int low, int high) {
    if (low > high) {
      return null;
    }
    if (low == high) {
      return new TreeNode(list.get(low));
    }
    int index = low + (high - low) / 2;
    TreeNode root = new TreeNode(list.get(index));
    root.left = sortedListHelper(list, low, index - 1);
    root.right = sortedListHelper(list, index + 1, high);
    return root;
  }

  private List<Integer> returnList(ListNode head) {
    ListNode current = head;
    ArrayList<Integer> alist = new ArrayList<>();
    while (current != null) {
      alist.add(current.val);
      current = current.next;
    }
    return alist;
  }


  @Test
  public void testConvertedSortedLLtoBST() {
    ListNode listNode = new ListNode(-10);
    listNode.next = new ListNode(-3);
    listNode.next.next = new ListNode(0);
    listNode.next.next.next = new ListNode(5);
    listNode.next.next.next.next = new ListNode(9);
    sortedListToBST(listNode);
  }


}
