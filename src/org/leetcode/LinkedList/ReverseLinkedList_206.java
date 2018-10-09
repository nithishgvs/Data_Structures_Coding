package org.leetcode.LinkedList;

import org.junit.Test;

public class ReverseLinkedList_206 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode current = head;
		ListNode nextNext = head;
		ListNode next = null;
		ListNode previous = null;
		while (current != null) {
			if (current.next != null) {
				next = current.next;
				nextNext = current.next.next;
				current.next = previous;
				next.next = current;
				previous = next;
				current = nextNext;
			} else {
				current.next = previous;
				return current;
			}
		}
		return null;
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
		System.out.println("Before Reverse");
		printLinkedList(head);
		ListNode testNode = reverseList(head);
		System.out.println("After Reverse");
		printLinkedList(testNode);

	}

}
