package org.leetcode.Arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_118 {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> pascalList = new ArrayList<>();
		if (numRows == 0)
			return pascalList;
		List<Integer> list = null;
		for (int i = 0; i < numRows; i++) {
			list = new ArrayList<>();
			list.add(0, 1);
			for (int j = 1; j <= i; j++) {
				List<Integer> prevList = pascalList.get(i - 1);
				if (prevList.size() > j)
					list.add(j, prevList.get(j) + prevList.get(j - 1));
				else
					list.add(j, prevList.get(i - 1));
			}
			pascalList.add(list);
			list = null;
		}
		return pascalList;
	}

	@Test
	public void test() {
		generate(1);
	}
}
