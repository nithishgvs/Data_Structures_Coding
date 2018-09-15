package org.leetcode.Strings;

//Zillow asked this
public class ReverseWordsString_151 {

	public String reverseWords(String s) {
		String after = s.trim().replaceAll("\\s+", " ");
		String[] arr = after.split(" ");
		String output = "";
		for (int i = arr.length - 1; i >= 0; i--) {
			output += arr[i] + " ";
		}
		return output.trim();
	}

}
