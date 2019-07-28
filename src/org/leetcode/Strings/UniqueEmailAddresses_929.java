package org.leetcode.Strings;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class UniqueEmailAddresses_929 {

  public int numUniqueEmails(String[] emails) {
    if (emails.length == 0) {
      return 0;
    }
    Set<String> set = new HashSet<>();

    for (String mail : emails) {
      String sub = mail.substring(0, mail.indexOf('@'));
      sub = sub.replaceAll("\\.", "");
      if (sub.contains("+")) {
        sub = sub.substring(0, sub.indexOf("+"));
      }
      sub += mail.substring(mail.indexOf('@'));
      set.add(sub);

    }

    return set.size();
  }


  @Test
  public void test1() {
    System.out.println(numUniqueEmails(
        new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
            "testemail+david@lee.tcode.com"}));
  }


  @Test
  public void test2() {
    System.out.println(numUniqueEmails(
        new String[]{"testemail@leetcode.com", "testemail1@leetcode.com",
            "testemail+david@lee.tcode.com"}));
  }

}
