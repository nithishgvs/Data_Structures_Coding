package org.leetcode.Tries;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class LongestWordInDictionary {

	class TrieNode {

		Map<Character, TrieNode> children;
		boolean endOfWord;

		public TrieNode() {
			children = new TreeMap<>();
			endOfWord = false;
		}

	}

	private TrieNode root = new TrieNode();
	private String output = "";

	public void insert(String word) {
		insertRecursive(root, word, 0);
	}

	private void insertRecursive(TrieNode current, String word, int index) {
		if (index == word.length()) {
			current.endOfWord = true;
			return;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if (node == null) {
			node = new TrieNode();
			current.children.put(ch, node);
		}
		insertRecursive(node, word, index + 1);
	}

	public String longestWord(String[] words) {
		for (String word : words) {
			this.insert(word);
		}

		for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
			if (entry.getValue().endOfWord) {
				dfsTrie(entry, entry.getKey() + "");
			}
		}

		return output;
	}

	private String dfsTrie(Map.Entry<Character, TrieNode> entry, String currentString) {
		for (Map.Entry<Character, TrieNode> children : entry.getValue().children.entrySet()) {
			if (children.getValue().endOfWord) {
				dfsTrie(children, currentString + children.getKey());
			}
		}
		if (currentString.length() > output.length()) {
			output = currentString;
		} else if (currentString.length() == output.length()) {
			if (output.compareTo(currentString) > 0) {
				output = currentString;
			}
		}
		return output;
	}

	@Test
	public void testLongestWord() {
		String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
		String[] words2 = { "w", "wo", "wor", "worl", "world" };
		String[] words3 = { "m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat" };
		System.out.println(longestWord(words3));
	}

}
