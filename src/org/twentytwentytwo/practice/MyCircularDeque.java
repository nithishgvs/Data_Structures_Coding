package org.twentytwentytwo.practice;

public class MyCircularDeque {


  private final static int SPECIAL_VALUE = -1;

  int headIndex;
  int tailIndex;
  int[] queue;

  public MyCircularDeque(int k) {
    headIndex = SPECIAL_VALUE;
    tailIndex = SPECIAL_VALUE;
    queue = new int[k];
  }

  public boolean insertFront(int value) {
    if (isFull()) {
      return false;
    }
    headIndex = (headIndex + 1) % queue.length;
    if (tailIndex == SPECIAL_VALUE) {
      tailIndex = headIndex;
    }
    queue[headIndex] = value;
    return true;
  }

  public boolean insertLast(int value) {
    if (isFull()) {
      return false;
    }
    tailIndex = (tailIndex + 1) % queue.length;
    queue[tailIndex] = value;
    return true;
  }

  public boolean deleteFront() {
    if (isEmpty()) {
      return false;
    }
    if (headIndex == tailIndex) {
      headIndex = SPECIAL_VALUE;
    } else {
      headIndex = (headIndex + 1) % queue.length;
    }
    return true;

  }

  public boolean deleteLast() {
    if (isEmpty()) {
      return false;
    }
    if (headIndex == tailIndex) {
      headIndex = SPECIAL_VALUE;
    } else {
      tailIndex = (tailIndex + 1) % queue.length;
    }
    return true;
  }

  public int getFront() {
    if (isEmpty()) {
      return -1;
    }
    return queue[headIndex];
  }

  public int getRear() {
    if (isEmpty()) {
      return -1;
    }
    return queue[tailIndex];
  }

  public boolean isEmpty() {
    return headIndex == SPECIAL_VALUE;
  }

  public boolean isFull() {
    int nextIndex = (tailIndex + 1) % queue.length;
    return nextIndex == headIndex;
  }

  public static void main(String[] args) {
    MyCircularDeque myCircularDeque = new MyCircularDeque(3);
    System.out.println(myCircularDeque.insertLast(1));  // return True
    System.out.println(myCircularDeque.insertLast(2));  // return True
    System.out.println(myCircularDeque.insertFront(3)); // return True
    System.out.println(myCircularDeque.insertFront(4)); // return False, the queue is full.
    System.out.println(myCircularDeque.getRear());      // return 2
    System.out.println(myCircularDeque.isFull());       // return True
    System.out.println(myCircularDeque.deleteLast());   // return True
    System.out.println(myCircularDeque.insertFront(4)); // return True
    System.out.println(myCircularDeque.getFront());     // return 4
  }
}
