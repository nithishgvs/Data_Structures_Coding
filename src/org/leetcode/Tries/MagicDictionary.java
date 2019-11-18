package org.leetcode.Tries;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

//ImplementMagicDictionary_676
//Set implementation
public class MagicDictionary {


  Set<String> dictionary;

  /**
   * Initialize your data structure here.
   */
  public MagicDictionary() {
    dictionary = new HashSet<>();
  }


  /**
   * Build a dictionary through a list of words
   */
  public void buildDict(String[] dict) {

    for (String entry : dict) {
      dictionary.add(entry);
    }
  }

  /**
   * Returns if there is any word in the trie that equals to the given word after modifying exactly
   * one character
   */
  public boolean search(String word) {
    for (String dict : dictionary) {
      if (oneLetterChange(dict, word)) {
        return true;
      }
    }

    return false;
  }

  private boolean oneLetterChange(String dict, String word) {
    int diff = 0;
    if (dict.length() != word.length()) {
      return false;
    }

    for (int i = 0; i < dict.length(); i++) {
      if (dict.charAt(i) != word.charAt(i)) {
        diff++;
      }
      if (diff > 1) {
        return false;
      }
    }

    return diff == 1;
  }

  @Test
  public void test() {
    buildDict(new String[]{"hello", "leetcode"});
    //System.out.println(search("hello"));
    System.out.println(search("hhllo"));
    System.out.println(search("hell"));
    System.out.println(search("leetcoded"));
    //System.out.println(search("hello"));

  }

  @Test
  public void test1() {
    buildDict(new String[]{"hello", "hallo", "leetcode"});
    System.out.println(search("hello"));
    System.out.println(search("hhllo"));
    System.out.println(search("hell"));
    System.out.println(search("leetcoded"));
    //System.out.println(search("hello"));

  }

  @Test
  public void test2() {
    buildDict(new String[]{"a", "b", "ab", "abc"});
    //System.out.println(search("hello"));
    System.out.println(search("abb"));
    System.out.println(search("hell"));
    System.out.println(search("leetcoded"));
    //System.out.println(search("hello"));

  }

  @Test
  public void test3() {
    buildDict(new String[]{"a", "b"});
    //System.out.println(search("hello"));
    System.out.println(search("a"));
    System.out.println(search("b"));
    System.out.println(search("c"));
    //System.out.println(search("hello"));

  }

}
