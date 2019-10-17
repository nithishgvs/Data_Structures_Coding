package org.leetcode.Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class LongestCommonPrefix_14 {


  public class TrieNode {

    private Map<Character, TrieNode> children;
    private boolean endofWord;

    public TrieNode() {
      this.children = new HashMap<>();
      this.endofWord = false;
    }
  }


  private TrieNode root = new TrieNode();

  public void insert(String word) {
    if (word.length() < 0) {
      return;
    }
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      Character ch = word.charAt(i);
      TrieNode node = current.children.get(ch);
      if (node == null) {
        node = new TrieNode();
        current.children.put(ch, node);
      }
      current = node;
    }
    current.endofWord = true;
  }

  public String longestCommonPrefix(String[] strs) {

    if (strs.length == 1) {
      return strs[0];
    }

    for (String str : strs) {
      insert(str);
    }

    return longestCommonPrefixHelper(root);

  }

  private String longestCommonPrefixHelper(TrieNode root) {

    TrieNode current = root;

    StringBuilder sb = new StringBuilder();

    while (current != null) {
      List<Character> list = null;
      if (current.children.size() == 1 && !current.endofWord) {
        list = new ArrayList<>(current.children.keySet());
        sb.append(list.get(0));
      } else {
        break;
      }
      current = current.children.get(list.get(0));
    }

    return sb.toString();
  }


  @Test
  public void test() {
    System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
  }

  @Test
  public void test1() {
    System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
  }//["","b"]


  @Test
  public void test2() {
    System.out.println(longestCommonPrefix(new String[]{"", "b"}));
  }

  @Test
  public void test3() {
    System.out.println(longestCommonPrefix(new String[]{"aaa", "aa","aaa"}));
  }
}
