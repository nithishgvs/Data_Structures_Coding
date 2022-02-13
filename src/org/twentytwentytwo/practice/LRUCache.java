package org.twentytwentytwo.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 * Leetcode 146
 */
public class LRUCache {

  public class Node {

    int key;
    int value;
    Node prev;
    Node next;
  }

  int totalElements = 0;
  Map<Integer, Node> map;
  Node head;
  Node tail;
  int maxElements = 0;

  public LRUCache(int capacity) {
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.prev = head;
    map = new HashMap<>();
    maxElements = capacity;
  }

  public int get(int key) {
    Node node = map.get(key);
    if (node != null) {
      moveToHead(node);
      return node.value;
    }
    return -1;
  }

  public void put(int key, int value) {

    Node node = map.get(key);
    if (node == null) {
      node = new Node();
      node.key = key;
      node.value = value;
      totalElements++;
      addToHead(node);
      map.put(key, node);
      if (totalElements > maxElements) {
        removeElementFromTail();
        totalElements--;
      }
    } else {
      node.value = value;
      map.put(key, node);
      moveToHead(node);
    }
  }

  private void moveToHead(Node node) {
    removeFromList(node);
    addToHead(node);
  }

  private void removeElementFromTail() {
    Node toBeRemoved = tail.prev;
    toBeRemoved.prev.next = tail;
    tail.prev = toBeRemoved.prev;
    map.remove(toBeRemoved.key);
  }

  private void addToHead(Node node) {
    Node next = head.next;
    next.prev = node;
    node.next = next;
    node.prev = head;
    head.next = node;
  }

  private void removeFromList(Node node) {
    Node next = node.next;
    Node prev = node.prev;
    prev.next = next;
    next.prev = prev;
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
