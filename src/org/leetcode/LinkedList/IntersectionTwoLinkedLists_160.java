package org.leetcode.LinkedList;

import org.junit.Test;

public class IntersectionTwoLinkedLists_160 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		ListNode currentA = headA;
		ListNode currentB = headB;
		int lengthA = 0;
		int lengthB = 0;
		while (currentA != null) {
			lengthA++;
			currentA = currentA.next;
		}
		while (currentB != null) {
			lengthB++;
			currentB = currentB.next;
		}

		currentA = headA;
		currentB = headB;

		if (lengthA > lengthB) {
			for (int i = 0; i < lengthA - lengthB; i++) {
				currentA = currentA.next;
			}
		} else {
			for (int i = 0; i < lengthB - lengthA; i++) {
				currentB = currentB.next;
			}
		}

		while (currentA != currentB) {
			currentA = currentA.next;
			currentB = currentB.next;
		}

		return currentB;
	}

	@Test
	public void testIntersection() {
		ListNode headA = new ListNode(2);
		headA.next = new ListNode(3);

		// 1,3,5,7,9,11,13,15,17,19,21

		ListNode headB = new ListNode(3);
		getIntersectionNode(headA, headB);

	}

}
