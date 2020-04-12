package org.leetcode.Design;

//DesignPhoneDirectory_379

import java.util.ArrayList;
import java.util.List;

public class PhoneDirectory {

  List<Integer> directory = new ArrayList<>();

  /**
   * Initialize your data structure here
   *
   * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
   */
  public PhoneDirectory(int maxNumbers) {
    for (int i = 0; i < maxNumbers; i++) {
      directory.add(i);
    }

  }

  /**
   * Provide a number which is not assigned to anyone.
   *
   * @return - Return an available number. Return -1 if none is available.
   */
  public int get() {

    if (!directory.isEmpty()) {
      int availableNumber = directory.get(0);
      directory.remove(0);
      return availableNumber;
    }

    return -1;

  }

  /**
   * Check if a number is available or not.
   */
  public boolean check(int number) {

    return directory.contains(number);

  }

  /**
   * Recycle or release a number.
   */
  public void release(int number) {
    if (!directory.contains(number)) {
      directory.add(number);
    }
  }


  public static void main(String[] args) {
    // Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
    PhoneDirectory directory = new PhoneDirectory(2);

// It can return any available phone number. Here we assume it returns 0.
    directory.get();

// Assume it returns 1.
    directory.release(0);

// The number 2 is available, so return true.
    directory.check(0);
    directory.check(0);

// It returns 2, the only number that is left.
    directory.get();

// The number 2 is no longer available, so return false.
    directory.get();
    directory.check(0);
    directory.get();
    directory.get();
    directory.get();

  }

}
