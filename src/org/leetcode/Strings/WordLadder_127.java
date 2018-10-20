package org.leetcode.Strings;

import org.junit.Test;

import java.util.*;

public class WordLadder_127 {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		if (!wordList.contains(endWord))
			return 0;
		Queue<QItem> queue = new LinkedList<QItem>();
		queue.add(new QItem(1, beginWord));

		while (!queue.isEmpty()) {
			QItem item = queue.poll();
			ListIterator<String> iter = wordList.listIterator();
			while (iter.hasNext()) {
				String currentWord = iter.next();
				if (oneLetterChange(item.word, currentWord)) {
					item.length = item.length + 1;
					item.word = currentWord;
					queue.add(item);
					iter.remove();
					if (currentWord.equals(endWord)) {
						return item.length;
					}
				}
			}
		}
		return 0;
	}

	private boolean oneLetterChange(String word1, String word2) {
		int count = 0;
		for (int i = 0; i < word1.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i))
				count++;
			if (count > 1)
				break;
		}
		return count == 1 ? true : false;
	}

	class QItem {
		int length;
		String word;

		public QItem(int length, String word) {
			this.length = length;
			this.word = word;
		}
	}

	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.remove();
				if (cur.equals(endWord)) {
					return level + 1;
				}
				for (int j = 0; j < cur.length(); j++) {
					char[] word = cur.toCharArray();
					for (char ch = 'a'; ch < 'z'; ch++) {
						word[j] = ch;
						String check = new String(word);
						if (!check.equals(cur) && wordList.contains(check)) {
							queue.add(check);
							wordList.remove(check);
						}
					}
				}
			}
			level++;
		}
		return 0;
	}

	@Test
	public void test() {
		// System.out.println(
		// ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot",
		// "dot", "dog", "lot", "log", "cog"))));

		System.out.println(
				ladderLength("hit", "cog", new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
	}

}
