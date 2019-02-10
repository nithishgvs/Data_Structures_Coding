package org.leetcode.LinkedList;

import org.junit.Test;

public class SplitLinkedListParts_725 {

  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode[] splitListToParts(ListNode root, int k) {
    int length = listLength(root);
    if (length == 0) {
      return new ListNode[k];
    }
    int elemFilling = length / k;
    int remainder = length % k;
    boolean flag = false;
    if(length<k){
      elemFilling=1;
    }
    else if (length % k != 0) {
      elemFilling++;
      flag = true;
    }
    ListNode[] outputList = new ListNode[k];
    ListNode current = root;
    int i = 0;
    int j = 0;
    int rem = 0;
    while (current != null) {
      ListNode listNode = null;
      ListNode listNodeCurrent = null;
      while (i < elemFilling && current != null) {
        if (listNode == null) {
          listNode = new ListNode(current.val);
          listNodeCurrent = listNode;
        } else {
          listNodeCurrent.next = new ListNode(current.val);
          listNodeCurrent = listNodeCurrent.next;
        }
        i++;
        current = current.next;
      }

      rem++;
      if (flag && rem == remainder) {
        flag = false;
        elemFilling--;
      }
      i = 0;
      outputList[j] = listNode;
      j++;
    }
    return outputList;
  }

  private int listLength(ListNode root) {
    ListNode current = root;
    int length = 0;
    while (current != null) {
      current = current.next;
      length++;
    }
    return length;
  }

  @Test
  public void splitList() {
    ListNode root = new ListNode(1);
    root.next = new ListNode(2);
    root.next.next = new ListNode(3);
    root.next.next.next = new ListNode(4);
    root.next.next.next.next = new ListNode(5);
    root.next.next.next.next.next = new ListNode(6);
    root.next.next.next.next.next.next = new ListNode(7);
    //root.next.next.next.next.next.next.next = new ListNode(8);
    System.out.println(splitListToParts(root, 8).length);
  }

  @Test
  public void splitList2() {
    ListNode root = new ListNode(1);
    root.next = new ListNode(2);
//    root.next.next = new ListNode(3);
//    root.next.next.next = new ListNode(4);
//    root.next.next.next.next = new ListNode(5);
//    root.next.next.next.next.next = new ListNode(6);
//    root.next.next.next.next.next.next = new ListNode(7);
//    root.next.next.next.next.next.next.next = new ListNode(8);
    System.out.println(splitListToParts(root, 4).length);
  }

}
