package org.leetcode.Trees;

import org.junit.Test;

import java.util.*;

public class FindModeBinarySearchTree_501 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> inOrderList = new ArrayList<>();
    int currentMax = 1;
    int maxOccurence = 1;

    public int[] findMode(TreeNode root) {
        inOrderRecursive(root);
        Collections.sort(inOrderList);
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> tempSet = new HashSet<>();
        for (Integer val : inOrderList) {
            if (map.containsKey(val) && map.get(val) >= currentMax) {
                currentMax++;
                if (currentMax == maxOccurence) {
                    tempSet.add(val);
                    maxOccurence = currentMax;
                }else if (currentMax>maxOccurence){
                    tempSet.removeAll(tempSet);
                    tempSet.add(val);
                    maxOccurence = currentMax;
                }
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
                currentMax = 1;
            }
        }

        if (tempSet.isEmpty()) {
            tempSet.addAll(inOrderList);
        }
        return tempSet.stream().mapToInt(Integer::intValue).toArray();
    }

    public void inOrderRecursive(TreeNode root) {
        if (root == null)
            return;
        inOrderRecursive(root.left);
        inOrderList.add(root.val);
        inOrderRecursive(root.right);
    }

    @Test
    public void treeTest() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(3);
        System.out.println(findMode(root));
    }

    @Test
    public void treeTest2() {
        TreeNode root = new TreeNode(52);
        root.left = new TreeNode(33);
        root.left.left = new TreeNode(25);
        root.left.left.left = new TreeNode(12);
        root.left.left.right = new TreeNode(27);
        root.left.right = new TreeNode(39);
        root.left.right.left = new TreeNode(34);
        root.left.right.right = new TreeNode(48);
        root.right = new TreeNode(65);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(78);
        root.right.right.left = new TreeNode(72);
        root.right.right.right = new TreeNode(90);
        System.out.println(findMode(root));
    }

    @Test
    public void treeTest3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(findMode(root));
    }

    @Test
    public void treeTest4() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        System.out.println(findMode(root));
    }

    @Test
    public void treeTest5() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(2);
        root.left.right.right = new TreeNode(6);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(findMode(root));
    }

    @Test
    public void treeTest6() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(1);
        root.right.left.right = new TreeNode(2);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.left.right = new TreeNode(2);
        root.right.left.right.left.right.left = new TreeNode(2);

        System.out.println(findMode(root));
    }

}
