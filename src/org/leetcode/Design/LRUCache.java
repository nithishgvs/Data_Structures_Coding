package org.leetcode.Design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {


  private class ListNode {

    int key;
    int value;
    ListNode next;
    ListNode prev;
  }

  int totalElements = 0;

  int maxCapacity = 0;

  ListNode head;
  ListNode tail;

  Map<Integer, ListNode> map;


  public LRUCache(int capacity) {
    maxCapacity = capacity;
    head = new ListNode();
    tail = new ListNode();
    head.next = tail;
    tail.prev = head;
    map = new HashMap<>();
  }

  public int get(int key) {

    ListNode node = map.get(key);

    if (node != null) {
       moveToHead(node);
      return node.value;
    }

    return -1;
  }

  private void moveToHead(ListNode node) {
    removeFromList(node);
    addToHead(node);
  }

  private void addToHead(ListNode node) {
    ListNode currentFirst = head.next;
    currentFirst.prev = node;
    node.prev = head;
    node.next = currentFirst;
    head.next = node;
  }

  private void removeFromList(ListNode node) {
    ListNode next = node.next;
    ListNode prev = node.prev;

    prev.next = next;
    next.prev = prev;
  }

  public void put(int key, int value) {
    ListNode node = map.get(key);
    if (node == null) {
      ListNode newNode = new ListNode();
      newNode.key = key;
      newNode.value = value;
      map.put(key, newNode);
      addElementToHead(newNode);
      totalElements++;
      if (totalElements > maxCapacity) {
        removeElementFromTail();
      }
    } else {
      node.value = value;
      moveToHead(node);
    }
  }

  private void addElementToHead(ListNode newNode) {
    ListNode node = head.next;
    newNode.next = node;
    newNode.prev = head;
    head.next = newNode;
    node.prev = newNode;
  }

  private void removeElementFromTail() {
    ListNode node = tail.prev;
    node.prev.next = tail;
    tail.prev = node.prev;
    totalElements--;
    map.remove(node.key);
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
//    cache.put(1, 1);
//    cache.put(2, 2);
//    System.out.println(cache.get(1));       // returns 1
//    cache.put(3, 3);    // evicts key 2
//    System.out.println(cache.get(2));       // returns -1 (not found)
//    cache.put(4, 4);    // evicts key 1
//    System.out.println(cache.get(1));       // returns -1 (not found)
//    System.out.println(cache.get(3));       // returns 3
//    System.out.println(cache.get(4));       // returns 4
    cache.put(2, 1);
    cache.put(1, 1);
    cache.put(2, 3);
    cache.put(4, 1);
    System.out.println(cache.get(1));
    System.out.println(cache.get(2));

  }
}
