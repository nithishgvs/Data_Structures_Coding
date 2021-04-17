package org.leetcode.Bracktracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();

  
    backTrackingHelper("", n, n, result);
    return result;
  }

  private void backTrackingHelper(String s, int n, int n1, List<String> result) {
  }


}
