package org.leetcode.Hashing;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ReplaceWords_648 {

	public String replaceWords(List<String> dict, String sentence) {
		StringBuffer output = new StringBuffer();
		String[] strArray = sentence.split("\\s+");
		for (String word : strArray) {
			int length = word.length();
			int i = 0;
			while (i < length) {
				String sub = word.substring(0, i + 1);
				if (dict.contains(sub)) {
					word = sub;
					break;
				}
				i++;
			}
			output.append(word).append(" ");
		}

		return output.toString().trim();
	}

	@Test
	public void test() {
		List<String> dict = Arrays.asList("cat", "bat", "rat");
		System.out.println(replaceWords(dict, "the cattle was rattled by the battery"));

	}

}
