package org.lcfresh.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class LongestCommonPrefix_14 {

  public class TrieNode {

    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
      this.children = new HashMap<>();
      this.endOfWord = false;
    }
  }

  TrieNode root = new TrieNode();

  public void insert(String word) {
    if (word.length() < 0) {
      return;
    }
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char character = word.charAt(i);
      TrieNode trieNode = current.children.get(character);
      if (trieNode == null) {
        trieNode = new TrieNode();
        current.children.put(character, trieNode);
      }
      current = trieNode;
    }
    current.endOfWord = true;
  }


  public String longestCommonPrefix(String[] strs) {
    for (String str : strs) {
      insert(str);
    }
    return longestPrefixHelper(root);

  }

  private String longestPrefixHelper(TrieNode root) {
    StringBuilder stringBuilder = new StringBuilder();
    TrieNode current = root;

    while (current.children.size() == 1 && !current.endOfWord) {
      Set<Character> keySet = current.children.keySet();
      for (Character key : keySet) {
        stringBuilder.append(key);
        current = current.children.get(key);
      }
    }

    return stringBuilder.toString();
  }


  @Test
  public void test1() {
    String[] strs = {" ", "b"};
    System.out.println(longestCommonPrefix(strs));
  }
}
