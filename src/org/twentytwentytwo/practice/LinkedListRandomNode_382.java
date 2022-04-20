package org.twentytwentytwo.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ListNode {

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

public class LinkedListRandomNode_382 {


  List<ListNode> list;
  Random random;

  public LinkedListRandomNode_382(ListNode head) {

    random = new Random();
    list = new ArrayList<>();

    while (head != null) {
      list.add(head);
      head = head.next;
    }

  }

  public int getRandom() {
    int index = random.nextInt(list.size());
    return list.get(index).val;
  }

  public static void main(String[] args) {
    ListNode listNode = new ListNode(1);
    listNode.next = new ListNode(1);
    listNode.next.next = new ListNode(2);
    listNode.next.next.next = new ListNode(4);
    listNode.next.next.next.next = new ListNode(5);
    listNode.next.next.next.next.next = new ListNode(6);
    LinkedListRandomNode_382 obj = new LinkedListRandomNode_382(listNode);
    System.out.println(obj.getRandom());
    System.out.println(obj.getRandom());
    System.out.println(obj.getRandom());
    System.out.println(obj.getRandom());
  }


}
