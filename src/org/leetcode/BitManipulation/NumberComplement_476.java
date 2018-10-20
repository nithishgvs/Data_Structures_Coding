package org.leetcode.BitManipulation;

import org.junit.Test;

import java.util.ArrayList;

public class NumberComplement_476 {
	
	public int findComplement(int num) {
		ArrayList<Integer> compList = createBinaryNumberComplement(num);
		return binaryToDecimal(compList);
	}

	public ArrayList<Integer> createBinaryNumberComplement(int num) {
		ArrayList<Integer> complementList = new ArrayList<>();
		while (num > 0) {
			int digit = num % 2;
			if (digit == 1)
				complementList.add(0);
			else
				complementList.add(1);
			num = num / 2;
		}
		return complementList;
	}

	public int binaryToDecimal(ArrayList<Integer> complementList) {
		int number = 0;
		for (int i = 0; i < complementList.size(); i++) {
			number += Math.pow(2, i) * complementList.get(i);
		}
		return number;
	}

	@Test
	public void testNumberComplement() {
     System.out.println(findComplement(1));
	}

}
