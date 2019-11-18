package org.leetcode.Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class CamelcaseMatching_1023 {


  class TrieNode {

    boolean endOFWord;
    Map<Character, TrieNode> children;

    public TrieNode() {
      this.children = new HashMap<>();
      this.endOFWord = false;

    }
  }

  TrieNode root = new TrieNode();

  public void insert(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      TrieNode node = current.children.get(word.charAt(i));
      if (node == null) {
        node = new TrieNode();
        current.children.put(word.charAt(i), node);
      }
      current = node;
    }
    current.endOFWord = true;
  }


  public List<Boolean> camelMatch(String[] queries, String pattern) {
    List<Boolean> camelList = new ArrayList<>();
    insert(pattern);
    for (int i = 0; i < queries.length; i++) {
      TrieNode current = root;
      String entry = queries[i];
      int j;
      for (j = 0; j < entry.length(); j++) {
        if (entry.charAt(j) >= 'a' && entry.charAt(j) <= 'z') {
          if (!current.children
              .containsKey(entry.charAt(j))) {
            continue;
          } else {
            current = current.children.get(entry.charAt(j));
          }

        } else if (entry.charAt(j) >= 'A' && entry.charAt(j) <= 'Z') {
          if (current.children
              .containsKey(entry.charAt(j))) {
            current = current.children.get(entry.charAt(j));
          } else {
            camelList.add(false);
            break;
          }
        }

      }
      if (j == entry.length()) {
        if (current.children.size() == 0) {
          camelList.add(true);
        } else {
          camelList.add(false);
        }
      }
    }

    return camelList;
  }


  @Test
  public void test1() {
    camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" },
        "FB");

    //insert("abc");
    //insert("abcd");
  }


  @Test
  public void test2() {
    camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" },
        "FoBa");

    //insert("abc");
    //insert("abcd");
  }

  @Test
  public void test3() {
    camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" },
        "FoBaT");

    //insert("abc");
    //insert("abcd");
  }
}
