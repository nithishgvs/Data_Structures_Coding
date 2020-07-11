package org.leetcode.Graphs;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.junit.Test;

public class AlienDictionary_269 {

  public String alienOrder1(String[] words) {

    // Create a map of char vs empty hashset. This will be used to create
    // a directional map. Eg: For ["wrt", "wrf", "er", "ett", "rftt"],
    // we'll form a directional graph:
    // t -> { f }, w -> { e }, r -> { t }, e -> { r }

    Map<Character, Set<Character>> g = new HashMap<>();
    int[] incoming = new int[26];
    for (String word: words) {
      for (char ch: word.toCharArray()) {
        g.putIfAbsent(ch, new HashSet<Character>());
      }
    }

    // Iterate on all word combinations (first and second, second and third, ...)
    for (int i = 0; i < words.length - 1; i++) {
      String first = words[i];
      String second = words[i + 1];

      // Iterate till the min length of two words being considered.
      int len = Math.min(first.length(), second.length());
      for (int j = 0; j < len; j++) {
        char out = first.charAt(j);
        char in = second.charAt(j);

        // No action needed as long as the chars are same. If different
        // char, add an entry of outgoing char vs incoming char set to form a
        // (directional) graph. Also populate the array of incoming char count.
        if (out != in) {
          if (!g.get(out).contains(in)) {
            g.get(out).add(in);
            incoming[in - 'a']++;
          }

          break;
        }

        // For when we have words combinations like: 'abc' and 'ab'
        if (j == len - 1 && first.length() > second.length()) {
          g.clear();
        }
      }
    }

    // Find the char/node which isn't outgoing (in the directional graph).
    // This will be the first char of the alien dictionary. Add this to
    // the queue, and perform BFS.
    StringBuilder sb = new StringBuilder();
    Queue<Character> queue = new LinkedList<>();
    for (char ch: g.keySet()) {
      if (incoming[ch - 'a'] == 0) {
        queue.offer(ch);
      }
    }

    // BFS. Add chars to StringBuilder along the way.
    while (!queue.isEmpty()) {
      char curr = queue.remove();
      sb.append(curr);
      if (g.get(curr) == null || g.get(curr).size() == 0) continue;

      for (char ch: g.get(curr)) {
        incoming[ch - 'a']--;
        if (incoming[ch - 'a'] == 0) {
          queue.offer(ch);
        }
      }
    }

    return sb.length() == g.size() ? sb.toString() : "";
  }
  public String alienOrder(String[] words) {

    StringBuilder result = new StringBuilder();

    Map<Character, Set<Character>> adjacentSetMap = new HashMap<>();

    Map<Character, Integer> inDegreeMap = new LinkedHashMap<>();

    buildGraph(words, adjacentSetMap, inDegreeMap);

    Queue<Character> queue = new ArrayDeque<>();

    //Check for indegree and add to queue

    for (char key : adjacentSetMap.keySet()) {
      if (inDegreeMap.getOrDefault(key, 0) == 0) {
        queue.offer(key);
      }
    }

    while (!queue.isEmpty()) {
      Character popped = queue.poll();
      result.append(popped);
      Set<Character> adjVertices = adjacentSetMap.get(popped);
      if (adjVertices != null) {
        for (Character adj : adjVertices) {
          int updatedInDegree = inDegreeMap.get(adj) - 1;
          if (updatedInDegree == 0) {
            queue.add(adj);
          }
          inDegreeMap.put(adj, updatedInDegree);
        }
      }
    }

    if (result.length() != adjacentSetMap.size()) {
      return "";
    }

    return result.toString();

  }

  private void buildGraph(String[] words, Map<Character, Set<Character>> adjacentVerticesMap,
      Map<Character, Integer> inDegreeMap) {

    for (String word : words) {
      for (char c : word.toCharArray()) {
        adjacentVerticesMap.put(c, new HashSet<>());
      }
    }
    for (int i = 1; i < words.length; i++) {

      String previousWord = words[i - 1];
      String currentWord = words[i];

      int index = Math.min(currentWord.length(), previousWord.length());

      for (int j = 0; j < index; j++) {

        char prevChar = previousWord.toCharArray()[j];
        char currChar = currentWord.toCharArray()[j];

        if (!inDegreeMap.containsKey(prevChar)) {
          inDegreeMap.put(prevChar, 0);
        }

        if (!inDegreeMap.containsKey(currChar)) {
          inDegreeMap.put(currChar, 0);
        }

        if (prevChar != currChar) {
          if (!adjacentVerticesMap.get(prevChar).contains(currChar)) {
            adjacentVerticesMap.get(prevChar).add(currChar);
            inDegreeMap.put(currChar, inDegreeMap.get(currChar) + 1);
          }
          break;
        }

        // For when we have words combinations like: 'abc' and 'ab'
        if (j == index - 1 && previousWord.length() > currentWord.length()) {
          adjacentVerticesMap.clear();
        }

      }

    }
  }


  @Test
  public void test() {
    String[] words = {"za", "zb", "ca", "cb"};
    System.out.println(alienOrder(words));

  }


  @Test
  public void test1() {
    String[] words = {
        "z",
        "x", "z"
    };
    System.out.println(alienOrder(words));

  }

  @Test
  public void test2() {
    String[] words = {
        "abc",
        "ab"
    };
    System.out.println(alienOrder(words));

  }


}
