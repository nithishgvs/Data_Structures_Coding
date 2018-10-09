package org.leetcode.LinkedList;

import org.junit.Test;

public class RotateList_61 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}


	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0) {
			return head;
		}
		ListNode current = head;
		int i = 1;
		while (current.next != null) {
			i++;
			current = current.next;
		}
		if (k % i == 0 ) {
			return head;
		}
		ListNode last = current;
		current = head;
		ListNode prev = null;
		for (int j = 0; j < i - (k % i); j++) {
			prev = current;
			current = current.next;
		}
		last.next = head;
		prev.next = null;
		return current;
	}

	public void printLinkedList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}

	@Test
	public void testRotateRight() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println("Before Swap");
		printLinkedList(head);
		ListNode testNode = rotateRight(head, 2);
		System.out.println("After Swap");
		printLinkedList(testNode);

	}

	@Test
	public void testRotateRight2() {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		System.out.println("Before Swap");
		printLinkedList(head);
		ListNode testNode = rotateRight(head, 4);
		System.out.println("After Swap");
		printLinkedList(testNode);

	}

	@Test
	public void testRotateRight3() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		System.out.println("Before Swap");
		printLinkedList(head);
		ListNode testNode = rotateRight(head, 3);
		System.out.println("After Swap");
		printLinkedList(testNode);

	}

	@Test
	public void testRotateRight4() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		System.out.println("Before Swap");
		printLinkedList(head);
		ListNode testNode = rotateRight(head, 2);
		System.out.println("After Swap");
		printLinkedList(testNode);

	}

	@Test
	public void sample() {
		// System.out.println(200 % 3);
		// System.out.println(2 % 3000);
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		System.out.println("Before Swap");
		printLinkedList(head);
		ListNode testNode = rotateRight(head, 2);
		System.out.println("After Swap");
		printLinkedList(testNode);
	}

	@Test
	public void sample2() {
		System.out.println(4 % 1);
		System.out.println(6/2);
	}
}
