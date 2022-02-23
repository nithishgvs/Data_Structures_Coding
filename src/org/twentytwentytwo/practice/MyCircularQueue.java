package org.twentytwentytwo.practice;

public class MyCircularQueue {

  private static final int SPECIAL_VALUE = -1;

  int headIndex;
  int tailIndex;
  int[] queue;

  public MyCircularQueue(int k) {
    headIndex = SPECIAL_VALUE;
    tailIndex = SPECIAL_VALUE;
    queue = new int[k];
  }

  public boolean enQueue(int value) {

    if (isFull()) {
      return false;
    }
    tailIndex = (tailIndex + 1) % queue.length;
    queue[tailIndex] = value;

    if (headIndex == SPECIAL_VALUE) {
      headIndex = tailIndex;
    }
    return true;

  }

  public boolean deQueue() {
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

  public int Front() {

    if (isEmpty()) {
      return -1;
    }

    return queue[headIndex];

  }

  public int Rear() {
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
    MyCircularQueue myCircularQueue = new MyCircularQueue(3);
    System.out.println(myCircularQueue.enQueue(1)); // return True
    System.out.println(myCircularQueue.enQueue(2)); // return True
    System.out.println(myCircularQueue.enQueue(3)); // return True
    System.out.println(myCircularQueue.enQueue(4)); // return False
    System.out.println(myCircularQueue.Rear());     // return 3
    System.out.println(myCircularQueue.isFull());   // return True
    System.out.println(myCircularQueue.deQueue());  // return True
    System.out.println(myCircularQueue.enQueue(4)); // return True
    System.out.println(myCircularQueue.Rear());     // return 4
  }
}
