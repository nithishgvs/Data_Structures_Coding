package org.lcfresh.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class SearchSuggestionsSystem_1268 {

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    List<List<String>> output = new ArrayList<>();

    List<String> productList = new ArrayList<>();

    for (String product : products) {
      productList.add(product);
    }

    Collections.sort(productList);

    for (int i = 0; i < searchWord.length(); i++) {
      String interested = searchWord.substring(0, i + 1);
      List<String> subList = new ArrayList<>();

      for (int j = 0; j < productList.size(); j++) {
        if (productList.get(j).startsWith(interested)) {
          subList.add(productList.get(j));
          if (subList.size() == 3) {
            break;
          }
        }
      }
      output.add(subList);
    }

    return output;
  }

  @Test
  public void test1() {
    String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
    suggestedProducts(products, "mouse");
  }


}
