package org.leetcode.LinkedList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import org.junit.Test;

public class NextGreaterNodeInLinkedList_1019 {

  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public class StackNode {

    Integer data;
    List<Integer> otherLargerNodes = new ArrayList<>();

    public StackNode(Integer data, List<Integer> otherLargerNodes) {
      this.data = data;
      this.otherLargerNodes = otherLargerNodes;
    }
  }


  public int[] nextLargerNodes(ListNode head) {
    int size = 0;

    Deque<Integer> stack1 = new ArrayDeque<>();
    ListNode current = head;

    while (current != null) {
      size++;
      stack1.push(current.val);
      current = current.next;
    }

    int[] nextLargerNodes = new int[size];

    Deque<Integer> stack2 = new ArrayDeque<>();
    stack2.push(stack1.pop());
    size = size - 1;

    while (!stack1.isEmpty()) {
      size = size - 1;

      Integer poppedElement = stack1.pop();

      while (!stack2.isEmpty() && stack2.peek() <= poppedElement) {
        stack2.pop();
      }
      if (!stack2.isEmpty() && poppedElement < stack2.peek()) {
        nextLargerNodes[size] = stack2.peek();
      }
      stack2.push(poppedElement);

    }

    return nextLargerNodes;
  }


  @Test
  public void testNextLarger1() {
    ListNode head = new ListNode(2);
    head.next = new ListNode(2);
    head.next.next = new ListNode(5);
    System.out.println(Arrays.toString(nextLargerNodes(head)));
  }

  @Test
  public void testNextLarger2() {
    ListNode head = new ListNode(2);
    head.next = new ListNode(7);
    head.next.next = new ListNode(4);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(5);
    System.out.println(Arrays.toString(nextLargerNodes(head)));
  }


  @Test
  public void testNextLarger3() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(7);
    head.next.next = new ListNode(5);
    head.next.next.next = new ListNode(1);
    head.next.next.next.next = new ListNode(9);
    head.next.next.next.next.next = new ListNode(2);
    head.next.next.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next.next.next = new ListNode(1);
    System.out.println(Arrays.toString(nextLargerNodes(head)));
  }


  @Test
  public void testNextLarger4() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    System.out.println(Arrays.toString(nextLargerNodes(head)));
  }

  @Test
  public void testNextLarger5() {
    ListNode head = new ListNode(9);
    head.next = new ListNode(7);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(7);
    head.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next = new ListNode(9);
    System.out.println(Arrays.toString(nextLargerNodes(head)));
  }

  @Test
  public void testNextLarger6() {
    ListNode head = new ListNode(7);
    head.next = new ListNode(2);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(6);
    head.next.next.next.next = new ListNode(9);
    head.next.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next.next = new ListNode(3);
    //head.next.next.next.next.next.next.next = new ListNode(1);
    System.out.println(Arrays.toString(nextLargerNodes(head)));
  }


  @Test
  public void testNextLarger7() {
    ListNode head = new ListNode(3);
    head.next = new ListNode(3);
    //head.next.next = new ListNode(5);
    //head.next.next.next = new ListNode(7);
    System.out.println(Arrays.toString(nextLargerNodes(head)));
  }


  @Test
  public void testNextLarger8() {
    ListNode head = new ListNode(28);
    head.next = new ListNode(36);
    head.next.next = new ListNode(46);
    head.next.next.next = new ListNode(5);
    head.next.next.next.next = new ListNode(43);
    head.next.next.next.next.next = new ListNode(13);
    head.next.next.next.next.next.next = new ListNode(32);
    head.next.next.next.next.next.next.next = new ListNode(14);
    head.next.next.next.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next.next.next.next = new ListNode(22);
    head.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(27);
    head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(14);
    head.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(50);
    System.out.println(Arrays.toString(nextLargerNodes(head)));
  }

}
