package org.leetcode.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class SubdomainVisitCount_811 {

  public List<String> subdomainVisits(String[] cpdomains) {

    Map<String, Integer> domainMap = new HashMap<>();

    for (int i = 0; i < cpdomains.length; i++) {
      String entry = cpdomains[i];
      String[] sub = entry.split("\\s");
      int value = Integer.parseInt(sub[0]);

      String domain = sub[1].substring(sub[1].lastIndexOf(".") + 1);

      domainMapUpdate(domainMap, value, domain);

      if (sub[1].chars().filter(num -> num == '.').count() > 1) {
        domain = sub[1].substring(sub[1].indexOf(".") + 1);
        domainMapUpdate(domainMap, value, domain);
      }

      domain = sub[1];

      domainMapUpdate(domainMap, value, domain);

    }

    return prepareList(domainMap);
  }

  private List<String> prepareList(Map<String, Integer> domainMap) {
    List<String> domainList = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : domainMap.entrySet()) {
      domainList.add(entry.getValue() + " " + entry.getKey());
    }
    return domainList;
  }

  private void domainMapUpdate(Map<String, Integer> domainMap, int value, String domain) {
    if (!domainMap.containsKey(domain)) {
      domainMap.put(domain, value);
    } else {
      domainMap.put(domain, domainMap.get(domain) + value);
    }
  }


  @Test
  public void testSubdomainCount() {
    String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
    subdomainVisits(cpdomains);
  }


}
