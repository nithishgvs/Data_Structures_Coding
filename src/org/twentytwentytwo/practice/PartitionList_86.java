package org.twentytwentytwo.practice;

import org.junit.Test;

public class PartitionList_86 {

  public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode partition(ListNode head, int x) {

    if (head == null || head.next == null) {
      return head;
    }

    ListNode lessHead = new ListNode(-1);
    ListNode moreHead = new ListNode(-1);
    ListNode less = lessHead;
    ListNode more = moreHead;
    ListNode node = head;
    while (node !=null ){
      if (node.val < x){
        less.next = node;
        less = less.next;
      }
      else{
        more.next = node;
        more = more.next;
      }
      node = node.next;
    }
    more.next = null;
    less.next = moreHead.next;
    return lessHead.next;
  }

  @Test
  public void test() {
    ListNode listNode = new ListNode(1);
    listNode.next = new ListNode(4);
    listNode.next.next = new ListNode(3);
    listNode.next.next.next = new ListNode(0);
    listNode.next.next.next.next = new ListNode(2);
    listNode.next.next.next.next.next = new ListNode(5);
    listNode.next.next.next.next.next.next = new ListNode(2);
    ListNode node1 = partition(listNode, 3);
    //System.out.println(node1);
  }


  @Test
  public void test2() {
    ListNode listNode = new ListNode(1);
    listNode.next = new ListNode(1);
//    listNode.next.next = new ListNode(3);
//    listNode.next.next.next = new ListNode(0);
//    listNode.next.next.next.next = new ListNode(2);
//    listNode.next.next.next.next.next = new ListNode(5);
//    listNode.next.next.next.next.next.next = new ListNode(2);
    ListNode node1 = partition(listNode, 1);
    //System.out.println(node1);
  }
}
