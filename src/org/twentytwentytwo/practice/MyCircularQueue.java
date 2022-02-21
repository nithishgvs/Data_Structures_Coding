package org.twentytwentytwo.practice;

public class MyCircularQueue {


  private static final int SPECIAL_EMPTY_VALUE = -1;

  int headIndex;
  int tailIndex;

  int[] array;

  public MyCircularQueue(int k) {
    array = new int[k];
    headIndex = SPECIAL_EMPTY_VALUE;
    tailIndex = SPECIAL_EMPTY_VALUE;
  }

  public boolean enQueue(int value) {
    if (isFull()) {
      return false;
    }
    tailIndex = (tailIndex + 1) % array.length;
    array[tailIndex] = value;

    if (headIndex == SPECIAL_EMPTY_VALUE) {
      headIndex = tailIndex;
    }
    return true;
  }

  public boolean deQueue() {

    if (isEmpty()) {
      return false;
    }
    System.out.println("Removing: " + array[headIndex]);
    if (headIndex == tailIndex) {
      headIndex = SPECIAL_EMPTY_VALUE;
    } else {
      headIndex = (headIndex + 1) % array.length;
    }
    return true;
  }

  public int Front() {
    if (isEmpty()) {
      return -1;
    }
    return array[headIndex];
  }

  public int Rear() {
    if (isEmpty()) {
      return -1;
    }
    return array[tailIndex];
  }

  public boolean isEmpty() {
    return headIndex == SPECIAL_EMPTY_VALUE;
  }

  public boolean isFull() {
    int nextIndex = (tailIndex + 1) % array.length;
    return nextIndex == headIndex;
  }


  public static void main(String[] args) {
    MyCircularQueue myCircularQueue = new MyCircularQueue(6);
    System.out.println(myCircularQueue.enQueue(6));
    System.out.println(myCircularQueue.Rear());
    System.out.println(myCircularQueue.Rear());
    System.out.println(myCircularQueue.deQueue());
    System.out.println(myCircularQueue.enQueue(5));
    System.out.println(myCircularQueue.Rear());
    System.out.println(myCircularQueue.deQueue());
    System.out.println(myCircularQueue.Front());
    System.out.println(myCircularQueue.deQueue());
    System.out.println(myCircularQueue.deQueue());
    System.out.println(myCircularQueue.deQueue());
  }

}
