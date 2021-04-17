package org.leetcode.Regex;

import org.junit.Test;

public class ValidateIPAddress_468 {


  public String validIPAddress(String IP) {
    String response = "Neither";
    if (IP.indexOf(".") != -1) {
      //this is ipV4
      String construct = "(([1-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.)(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){2}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
      if (IP.matches(construct)) {
        return "IPv4";
      }
    } else {
      String construct = "((([0-9a-fA-F]){1,4})\\:){7}([0-9a-fA-F]){1,4}";
      if (IP.matches(construct)) {
        return "IPv6";
      }
    }

    return response;
  }


  @Test
  public void test1() {
    System.out.println(validIPAddress("092.168.1.0"));
  }
}
