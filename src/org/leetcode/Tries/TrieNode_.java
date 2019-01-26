package org.leetcode.Tries;

import java.util.HashMap;
import java.util.Map;

public class TrieNode_ {

  public Map<Character, TrieNode_> children;

  public boolean endOfWord;


  public TrieNode_() {
    this.children = new HashMap<>();
    this.endOfWord = false;
  }
}
