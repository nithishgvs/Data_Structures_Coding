package org.leetcode.LinkedList;

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

}
