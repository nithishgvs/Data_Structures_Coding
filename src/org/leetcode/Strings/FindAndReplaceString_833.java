package org.leetcode.Strings;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class FindAndReplaceString_833 {

	/**
	 * Tried hard and copied solution
	 * 
	 * @param S
	 * @param indexes
	 * @param sources
	 * @param targets
	 * @return
	 */
	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {

		Map<Integer, String[]> treeMap = new TreeMap<>();
		for (int i = 0; i < indexes.length; i++)
			treeMap.put(indexes[i], new String[] { sources[i], targets[i] });

		StringBuilder sb = new StringBuilder();
		int start = 0;
		for (int idx : treeMap.keySet()) {
			if (S.indexOf(treeMap.get(idx)[0], idx) == idx) {
				sb.append(S.substring(start, idx)).append(treeMap.get(idx)[1]);
				start = idx + treeMap.get(idx)[0].length();
			}
		}

		if (start != S.length())
			sb.append(S.substring(start));

		return sb.toString();
	}

	@Test
	public void testFindReplaceString() {
		String S = "wqzzcbnwxc";
		int indexes[] = { 5, 2, 7 };
		String sources[] = { "bn", "zzc", "wxc" };
		String targets[] = { "t", "lwb", "nee" };
		// System.out.println(findReplaceString(S, indexes, sources, targets));
	}

	@Test
	public void testFindReplaceString2() {
		String S = "vmokgggqzp";
		int indexes[] = { 3, 5, 1 };
		String sources[] = { "kg", "ggq", "mo" };
		String targets[] = { "s", "so", "bfr" };
		System.out.println(findReplaceString(S, indexes, sources, targets));
	}

	@Test
	public void testFindReplaceString3() {
		String S = "abcd";
		int indexes[] = { 1, 2 };
		String sources[] = { "b", "cd" };
		String targets[] = { "eee", "ffff" };
		// System.out.println(findReplaceString(S, indexes, sources, targets));
	}

	@Test
	public void testFindReplaceString4() {
		String S = "ehvfwtrvcodllgjctguxeicjoudmxbevzrvravkidnricwsbnxmxvdckzahmqzbrlqugtmjvoqbxarmlgjeqcorhnodvnoqfomdp";
		int indexes[] = { 1, 31, 44, 70, 23, 73, 76, 92, 90, 86, 42, 4, 50, 17, 53, 20, 55, 15, 38, 64, 25, 9, 7, 68,
				60, 88, 96, 47, 57, 34, 81, 78, 28 };
		String sources[] = { "hvf", "vzr", "cw", "jvo", "jo", "qb", "ar", "noqf", "dv", "rh", "ri", "wt", "mx", "gux",
				"dc", "eic", "kz", "ct", "kidn", "lq", "ud", "odll", "vc", "tm", "qz", "no", "om", "bn", "ahm", "vra",
				"jeqco", "ml", "xb" };
		String targets[] = { "ajq", "zb", "r", "fai", "e", "zs", "io", "snxd", "nw", "oi", "ofb", "quq", "gj", "nsys",
				"dk", "sf", "muj", "ll", "hqx", "k", "n", "ptrya", "f", "qek", "u", "dhj", "e", "kr", "waj", "rvkr",
				"roaoeq", "mci", "djw" };
		// System.out.println(findReplaceString(S, indexes, sources, targets));
	}
}
