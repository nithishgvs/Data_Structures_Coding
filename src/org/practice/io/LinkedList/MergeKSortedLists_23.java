package org.practice.io.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;
import org.junit.Test;

public class MergeKSortedLists_23 {


  public ListNode mergeKLists(ListNode[] lists) {

    ListNode newHead = null;

    if (lists == null || lists.length == 0) {
      return newHead;
    }

    PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
        Comparator.comparingInt(a -> a.val));

    for (ListNode currentNode : lists) {
      addEntries(priorityQueue, currentNode);
    }

    ListNode current = newHead;

    while (!priorityQueue.isEmpty()) {
      if (newHead == null) {
        newHead = priorityQueue.poll();
        current = newHead;
        continue;
      }
      current.next = priorityQueue.poll();
      current = current.next;
    }

    return newHead;

  }

  private void addEntries(PriorityQueue<ListNode> priorityQueue, ListNode currentNode) {
    while (currentNode != null) {
      priorityQueue.add(new ListNode(currentNode.val));
      currentNode = currentNode.next;
    }
  }

  @Test
  public void testMergeKSortedLists1() {
    ListNode listNode1 = new ListNode(1);
    listNode1.next = new ListNode(4);
    listNode1.next.next = new ListNode(5);
    ListNode listNode2 = new ListNode(1);
    listNode2.next = new ListNode(3);
    listNode2.next.next = new ListNode(4);
    ListNode listNode3 = new ListNode(2);
    listNode3.next = new ListNode(6);
    ListNode outNode = mergeKLists(new ListNode[]{listNode1, listNode2, listNode3});
  }

}
