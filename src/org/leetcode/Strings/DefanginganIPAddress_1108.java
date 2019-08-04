package org.leetcode.Strings;

import org.junit.Test;

public class DefanginganIPAddress_1108 {

  public String defangIPaddr(String address) {
    return address.replaceAll("\\.", "[.]");
  }


  @Test
  public void test1(){
    System.out.println(defangIPaddr("1.1.1.1"));
  }
}
