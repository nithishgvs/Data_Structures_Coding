package org.nithishgvs.Practice;

class Thread1 extends Thread {

  @Override
  public void run() {
    System.out.println("thread 1 started");
    for (int i = 0; i < 1000000; i++) {
      System.out.println("Thread1: " + i);
    }
    System.out.println("thread 1 finished");
  }

}

class Thread2 extends Thread {

  @Override
  public void run() {
    System.out.println("thread 2 started");
    for (int i = 1000000; i < 200000000; i++) {
      System.out.println("Thread2: " + i);
    }
    System.out.println("thread 2 finished");
  }

}

public class ThreadPractice1 {

  public static void main(String[] args) {
    System.out.println(1 / 2);
    Thread1 thread1 = new Thread1();
    thread1.setPriority(Thread.MAX_PRIORITY);
    thread1.start();
    Thread2 thread2 = new Thread2();
    thread2.start();
  }


}
